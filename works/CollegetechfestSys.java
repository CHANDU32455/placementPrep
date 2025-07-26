
class participant {
    
    private int pid;
    private String name;
    private double fee;
    private int no_of_events;
    private double charge_per_event;

    // setters
    public void setParticipantId(int id){
        pid = id;
    }
        public void setName(String n){
            name = n;
        }
        public void setBaseRegistrationFee(double f){
            fee = f;
        }
        public void setNumberOfEvents(int ne){
            no_of_events = ne;
        }
        public void setEventChargePerEvent(double pec){
            charge_per_event = pec;
        }

        // getters
        public int getParticipantId(){
            return this.pid;
        }
        public String getName(){
            return this.name;
        }
        public double getBaseRegistrationFee(){
            return this.fee;
        }
        public int getNumberOfEvents(){
            return this.no_of_events;
        }
        public double getEventChargePerEvent(){
            return charge_per_event;
        }

        // methods
        public double calculateTotalFee(){
            return this.fee + (this.no_of_events * this.charge_per_event);
        }
        public void displayDetails(){
            System.out.println("Participant ID: "+ pid);
            System.out.println("Name: "+ name);
            System.out.println("Base Registration Fee: "+ fee);
            System.out.println("Event Charges: "+ no_of_events +" events @" + charge_per_event+"/event");
            System.out.println("Total Fee: "+ calculateTotalFee());
        }
    }

    class CollegetechfestSys {

        public static void main(String[] args) {
            participant p = new participant();
            p.setParticipantId(1);
            p.setName("chandu");
            p.setBaseRegistrationFee(1000);
            p.setNumberOfEvents(2);
            p.setEventChargePerEvent(500);
            p.displayDetails();

        }
    }
