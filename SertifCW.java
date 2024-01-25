import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Objects;

public class NoteBook
    {

        private int yearOfRelease;
        private String label;
        private int RAM;
        private int hardDiskSpace;
        private String OS;
        private String color;
        private int price;

        public NoteBook(int yearOfRelease, String label, int RAM, int hardDiskSpace, String OS, String color, int price)
        {
            this.yearOfRelease = yearOfRelease;
            this.label = label;
            this.RAM = RAM;
            this.hardDiskSpace = hardDiskSpace;
            this.OS = OS;
            this.color = color;
            this.price = price;
        }

        public int GetYearOfRelease()
        {
            return yearOfRelease;
        }

        public void SetYearOfRelease(int yearOfRelease)
        {
            this.yearOfRelease = yearOfRelease;
        }

        public String GetLabel()
        {
            return label;
        }

        public void SetLabel(String label)
        {
            this.label = label;
        }

        public int GetRAM()
        {
            return RAM;
        }

        public void SetRAM(int RAM)
        {
            this.RAM = RAM;
        }

        public int GetHardDiskSpace()
        {
            return hardDiskSpace;
        }

        public void SetHardDiskSpace(int hardDiskSpace)
        {
            this.hardDiskSpace = hardDiskSpace;
        }

        public String GetOS()
        {
            return OS;
        }

        public void SetOS(String OS)
        {
            this.OS = OS;
        }


        public String GetColor()
        {
            return color;
        }

        public void SetColor(String color)
        {
            this.color = color;
        }


        public int GetPrice()
        {
            return price;
        }

        public void SetPrice(int price)
        {
            this.price = price;
        }

        @Override
        public String toString ()
        {
            return "Год выпуска: '" + yearOfRelease + '\'' +
                 ", Фирма: " + label +
                 ", ОЗУ: '" + RAM + '\'' +
                 ", Объём жёсткого диска: '" + hardDiskSpace + '\'' +
                 ", Операционная система: '" + OS + '\'' +
                 ", Цвет: '" + color + '\'' +
                 ", Цена: '" + price + '\'';
        }

        @Override
        public  boolean equals(Object obj)
        {
            if (this == obj)
            {
                return true;
            }
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            NoteBook laptop = (NoteBook)obj;
            return yearOfRelease == laptop.yearOfRelease && label.equals(laptop.label) && RAM == laptop.RAM && hardDiskSpace == laptop.hardDiskSpace &&
        OS.equals(laptop.OS) && color.equals(laptop.color) && price == laptop.price;

        }
        @Override
        public int hashCode() {
            return Objects.hash(yearOfRelease, label, RAM, hardDiskSpace, OS, color, price);
        }



    }

public  class Market{
    public static void main (String [] args) 
        {
                NoteBook laptop1 = new  NoteBook(2018, "Acer Swift X1", 16, 512,
                "Windows 11", "Grey", 10);

                NoteBook laptop2 = new  NoteBook(2019, "Dell Inspiron 14 Pro", 8,
                256, "Linux", "Pink", 8);

                NoteBook laptop3 = new  NoteBook(2020, "HP Spectre X360", 32,
                1024, "Windows 10", "Red", 11);

                NoteBook laptop4 = new  NoteBook(2020, "ASUS ROG Zephyrus G14", 32,
                1024, "Windows 10", "Blue", 9);

                NoteBook laptop5 = new  NoteBook(2019, "Lenovo Yoga Slim 7", 16,
                512, "Windows 11", "Yellow", 8);

                NoteBook laptop6 = new  NoteBook(2018, "MSI Creator Z16", 64,
                2048, "Linux", "White", 11);

                NoteBook laptop7 = new  NoteBook(2017, "Razer Blade Stealth 13", 16,
                512, "Windows 11", "Black", 13);

                NoteBook laptop8 = new  NoteBook(2021, "Apple MacBook Air M2", 8,
                512, "Windows 11", "Grey", 20);

                NoteBook laptop9 = new  NoteBook(2018, "LG Gram 17", 16,
                1024, "Windows 10", "Brown", 11);
                
                NoteBook laptop10 = new  NoteBook(2019, "Microsoft Surface Laptop 4", 8,
                256, "Linux", "Pink", 8);

            Set <NoteBook> Notebooks = new HashSet<>(Arrays.asList(laptop1,laptop2,laptop3,laptop4,laptop5,laptop6,laptop7,laptop8,laptop9,laptop10 ));

            for (NoteBook Notebook : Notebooks) {
                System.out.println(Notebook);
            }

            RequestFromUser(Notebooks);
   
        }

        public static void RequestFromUser(Set<NoteBook> Notebooks) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Пожалуйста, введите цифру критерия, который Вам интересен: ");
                System.out.println("1: Год выпуска");
                System.out.println("2: Фирма ноутбука");
                System.out.println("3: Озу");
                System.out.println("4: Объём жёсткого диска");
                System.out.println("5: Операционная система");
                System.out.println("6: Цвет");
                System.out.println("7: Цена");

                int standart = scanner.nextInt();
                scanner.nextLine(); 
   
                Map<String, Object> filterstandart = new HashMap<>();
   
                switch (standart) {
                    case 1:
                        System.out.println("Введите желаемый год производства: " + getAllYears(Notebooks) + ":");
                        String year = scanner.nextLine();
                        filterstandart.put("year", year);
                        break;
                    case 2:
                        System.out.println("Введите желаемую фирму: " + getAllLabels(Notebooks) + ":");
                        String label = scanner.nextLine();
                        filterstandart.put("label", label);
                        break;
                    case 3:
                        System.out.println("Введите минимальный объем оперативной памяти:  " + getAllRAM(Notebooks) + ":");
                        int minRAM = scanner.nextInt();
                        filterstandart.put("RAM", minRAM);
                        break;
                    case 4:
                        System.out.println("Введите минимальный объём жёсткого диска " + getAllHardDiskSpac(Notebooks) + ":");
                        String HDS = scanner.nextLine();
                        filterstandart.put("HDS", HDS);
                        break;
                    case 5:
                        System.out.println("Введите желаемую операционную систему " + getAllOS(Notebooks) + ":");
                        int minOS = scanner.nextInt();
                        filterstandart.put("OS", minOS);
                        break;
                    case 6:
                        System.out.println("Введите желаемый цвет: " + getAllColor(Notebooks) + ":");
                        String color = scanner.nextLine();
                        filterstandart.put("color", color);
                        break;
                    case 7:
                        System.out.println("Введите минимальную цену: " + getAllPrice(Notebooks) + ":");
                        String price = scanner.nextLine();
                        filterstandart.put("price", price);
                        break;
                    default:
                        System.out.println("Неверено выбрал критерий!");
                        return;
                }
                
   
                Set<NoteBook> filteredLaptops = filterLaptops(Notebooks, filterstandart);
   
                System.out.println("Отфильтрованные ноутбуки:");
                for (NoteBook laptop : filteredLaptops) {
                    System.out.println(laptop);
                }
            }
        }
    
        public static Set<NoteBook> filterLaptops(Set<NoteBook> Notebooks, Map<String, Object> filterstandart) {
            return Notebooks.stream()
                    .filter(laptop -> filterstandart.get("year") == null || laptop.GetYearOfRelease() >=(int)(filterstandart.get("year")))
                    .filter(laptop -> filterstandart.get("label") == null || laptop.GetLabel().equals(filterstandart.get("label")))
                    .filter(laptop -> filterstandart.get("RAM") == null || laptop.GetRAM() >= (int) filterstandart.get("RAM"))
                    .filter(laptop -> filterstandart.get("HDS") == null || laptop.GetHardDiskSpace() >= (int)(filterstandart.get("HDS")))
                    .filter(laptop -> filterstandart.get("OS") == null || laptop.GetOS().equals(filterstandart.get("OS")))
                    .filter(laptop -> filterstandart.get("color") == null || laptop.GetColor().equals(filterstandart.get("color")))
                    .filter(laptop -> filterstandart.get("price") == null || laptop.GetPrice() >= (int)(filterstandart.get("price")))
                    .collect(Collectors.toSet());
        }
    
        public static Set<Integer> getAllYears(Set<NoteBook> Notebooks) {
            return Notebooks.stream()
                    .map(NoteBook::GetYearOfRelease)
                    .collect(Collectors.toSet());
        }
    
        public static Set<String> getAllLabels(Set<NoteBook> Notebooks) {
            return Notebooks.stream()
                    .map(NoteBook::GetLabel)
                    .collect(Collectors.toSet());
        }
    
        public static Set<Integer> getAllRAM(Set<NoteBook> Notebooks) {
            return Notebooks.stream()
                    .map(NoteBook::GetRAM)
                    .collect(Collectors.toSet());
        }
    
        public static Set<Integer> getAllHardDiskSpac(Set<NoteBook> Notebooks) {
            return Notebooks.stream()
                    .map(NoteBook::GetHardDiskSpace)
                    .collect(Collectors.toSet());
        }
    
        public static Set<String> getAllOS(Set<NoteBook> Notebooks) {
            return Notebooks.stream()
                    .map(NoteBook::GetOS)
                    .collect(Collectors.toSet());
        }
    
        public static Set<String> getAllColor(Set<NoteBook> Notebooks) {
            return Notebooks.stream()
                    .map(NoteBook::GetColor)
                    .collect(Collectors.toSet());
        }
    
        public static Set<Integer> getAllPrice(Set<NoteBook> Notebooks) {
            return Notebooks.stream()
                    .map(NoteBook::GetPrice)
                    .collect(Collectors.toSet());
        }
        
    } 
            

