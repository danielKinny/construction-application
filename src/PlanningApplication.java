import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

void main(String[] args){

    JobCatalog jobCatalog = new JobCatalog();



    try {
        Scanner scanner = new Scanner(new File("joblist.txt"));

        while (scanner.hasNextLine()) {
            String[] addressData = scanner.nextLine().strip().split("; ");
            Address jobAddress = new Address(addressData[0], Integer.parseInt(addressData[1]), addressData[2], addressData[3]);
            String desc = scanner.nextLine().strip();

            String[] equipment = scanner.nextLine().strip().split(";"); //line of all equipment, split by each piece of equipment
            String[] equipmentString;

            List<Equipment> reqEquipment = new ArrayList<Equipment>();

            for(String equipmentS : equipment){ //iterating through each piece of equipment

                equipmentString = equipmentS.split(", "); //split between desc and actual thing
                String equipmentDesc = equipmentString.length>1 ? equipmentString[1] : "";

                {
                    switch (equipmentString[0].trim()) {
                        case ("JackHammer"):
                            reqEquipment.add(new JackHammer(equipmentDesc));
                            break;
                        case ("ConcreteMixer"):
                            reqEquipment.add(new ConcreteMixer(equipmentDesc));
                            break;
                        case ("Scaffolding"):
                            reqEquipment.add(new ScaffoldingTower(equipmentDesc));
                            break;
                        case ("Torch"):
                            reqEquipment.add(new Torch(equipmentDesc));

                    }
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

        // logic for file writing

        /**
         *Mekelweg; 4; 2628CD; Delft
         *Construct a new bathroom on the 8th floor.
         *JackHammer, A hardened chisel for reinforced floors; ConcreteMixer, None;
         *24-10-2021
         */
    try{
        FileWriter fw = new FileWriter("joblist.txt");
        List<Job> jobList = jobCatalog.getJobs();
        for(int i = 0; i<jobCatalog.getJobs().size(); i++){

            String addressString = jobList.get(i).getLocation().getStreet() + "; " +
                                jobList.get(i).getLocation().getNumber()+ "; " +
                                jobList.get(i).getLocation().getZipCode()+ "; " +
                                jobList.get(i).getLocation().getCity() + "\n"
                                ;

            String equipmentString = "";

            for (Equipment e : jobList.get(i).getRequiredEquipment()){
                switch(e.getClass().toString()){

                    case "class ScaffoldingTower" :
                        equipmentString += "Scaffolding, "+e.getRequirements() +"; ";
                        break;
                    case "class Torch" :
                        equipmentString += "Torch, "+e.getRequirements() +"; ";
                        break;
                    case "class JackHammer" :
                        equipmentString += "JackHammer, "+e.getRequirements() +"; ";
                        break;
                    case "class ConcreteMixer" :
                        equipmentString += "ConcreteMixer, "+e.getRequirements() +"; ";
                        break;
                }
            }

            equipmentString = equipmentString.trim() + "\n";

            String dateString = jobList.get(i).getPlannedDate().toString() + (i==jobList.size()-1 ? "": "\n");
            fw.write(addressString+jobList.get(i).getDescription()+"\n"+equipmentString+dateString);

        }

        fw.close();

    } catch (Exception e){
        System.out.println(e.getMessage());
    }


    }


}

