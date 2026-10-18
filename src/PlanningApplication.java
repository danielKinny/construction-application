import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public static void main(String[] args){

    JobCatalog jobCatalog = new JobCatalog();



    try {
        Scanner scanner = new Scanner(new File("joblist.txt"));

        while (scanner.hasNextLine()) {
            String[] addressData = scanner.nextLine().strip().split("; ");
            Address jobAddress = new Address(addressData[0], Integer.parseInt(addressData[1]), addressData[2], addressData[3]);
            String desc = scanner.nextLine().strip();

            String[] equipment = scanner.nextLine().strip().split(";");
            String[] equipmentString;

            List<Equipment> reqEquipment = new ArrayList<Equipment>();

            for(String equipmentS : equipment){

                equipmentString = equipmentS.split(", ");
                String equipmentDesc = equipmentString.length>1 ? equipmentString[1] : "";

                switch(equipmentString[0]){
                    case ("JackHammer"):
                        reqEquipment.add(new JackHammer(equipmentDesc));
                        break;
                    case ("ConcreteMixer"):
                        reqEquipment.add(new ConcreteMixer(equipmentDesc));
                        break;
                    case ("ScaffoldingTower"):
                        reqEquipment.add(new ScaffoldingTower(equipmentDesc));
                        break;
                    case("Torch"):
                        reqEquipment.add(new Torch(equipmentDesc));

                }

            }

            String[] date = scanner.nextLine().strip().split("-");
            Date plannedDate = new Date(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
            jobCatalog.getJobs().add(new Job(jobAddress, desc, reqEquipment, plannedDate));
        }



    } catch(Exception e){

        System.out.println(e.getMessage());

    }



    int userInput = 1;
    System.out.println("Welcome to the application!");

    while (userInput!=7){

        System.out.println("Enter a number to begin: \n 1.  Show all jobs in the catalog \n 2. Add a new job \n 3-6 To be implemented. \n 7. Quit application");

        Scanner s = new Scanner(System.in);
        userInput = s.nextInt();
        s.nextLine();

        switch(userInput){

            case 1:
                System.out.println(jobCatalog.toString());
                break;
            case 2:

                System.out.println("Great! we can proceed by entering the address at which the job is taking place");

                System.out.println("Street name: ");
                String sName = s.nextLine();

                System.out.println("House number: ");
                int hNumber = s.nextInt();
                s.nextLine();

                System.out.println("Zip code: ");
                String zCode = s.nextLine();

                System.out.println("City: ");
                String city = s.nextLine();

                System.out.println("Enter the description of the job: ");
                String desc = s.nextLine();

                List<Equipment> eq = new ArrayList<>();

                System.out.println("Does the job need a jack hammer? (Y/N)");
                if (s.nextLine().equals("Y")){
                    System.out.println("What is the requirement to operate the jack hammer: ");
                    eq.add(new JackHammer(s.nextLine()));
                }

                System.out.println("Does the job need a torch? (Y/N)");
                if (s.nextLine().equals("Y")){
                    System.out.println("What is the requirement to operate the torch: ");
                    eq.add(new Torch(s.nextLine()));
                }

                System.out.println("Does the job need a concrete mixer? (Y/N)");
                if (s.nextLine().equals("Y")){
                    System.out.println("What is the requirement to operate the concrete mixer: ");
                    eq.add(new ConcreteMixer(s.nextLine()));
                }

                System.out.println("Does the job need a scaffolding tower? (Y/N)");
                if (s.nextLine().equals("Y")){
                    System.out.println("What is the requirement to operate the scaffolding tower: ");
                    eq.add(new ScaffoldingTower(s.nextLine()));
                }

                System.out.println("Day: ");
                int d = s.nextInt();
                System.out.println("Month: ");
                int m = s.nextInt();
                System.out.println("Year: ");
                int y = s.nextInt();

                jobCatalog.getJobs().add(new Job(new Address(sName, hNumber, zCode, city), desc, eq, new Date(d,m,y)));
                break;

        }

    }


}

