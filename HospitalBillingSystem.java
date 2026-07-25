abstract class Patient {
    private static int counter = 1000;

    private String patientId;
    private String patientName;
    private double treatmentCost;

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Patient.counter = counter;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    protected String generatePatientId() {
        return "P" + (++counter);
    }

    public abstract double calculateBill();
}

class GeneralPatient extends Patient {

    private double discount = 0;

    @Override
    public double calculateBill() {

        double bill = getTreatmentCost();

        if (bill > 50000) {
            discount = 5000;
            bill -= discount;
        }

        return bill;
    }

    public void patientDetails() {

        calculateBill();

        System.out.println("Bill Generated Successfully\n");

        System.out.println("Patient ID: " + getPatientId());
        System.out.println("Name: " + getPatientName());
        System.out.println("Treatment Cost: " + getTreatmentCost());
        System.out.println("Discount Applied: " + discount);
        System.out.println("Final Bill: " + calculateBill());
    }
}

class InsuredPatient extends Patient {

    private double additionalDiscount = 0;

    @Override
    public double calculateBill() {

        double bill = getTreatmentCost() * 0.30;

        if (getTreatmentCost() >= 50000) {
            additionalDiscount = 3000;
            bill -= additionalDiscount;
        }

        return bill;
    }

    public void patientDetails() {

        calculateBill();

        System.out.println("Bill Generated Successfully\n");

        System.out.println("Patient ID: " + getPatientId());
        System.out.println("Name: " + getPatientName());
        System.out.println("Treatment Cost: " + getTreatmentCost());
        System.out.println("Insurance coverage applied");

        if (additionalDiscount > 0) {
            System.out.println("Additional Discount Applied: "
                    + additionalDiscount);
        }

        System.out.println("Final Bill: " + calculateBill());
    }
}

public class HospitalBillingSystem {

    public static void main(String[] args) {

        GeneralPatient p1 = new GeneralPatient();

        p1.setPatientId(p1.generatePatientId());
        p1.setPatientName("Rahul");
        p1.setTreatmentCost(60000);

        p1.patientDetails();

        System.out.println("--------------------------------");

        InsuredPatient p2 = new InsuredPatient();

        p2.setPatientId(p2.generatePatientId());
        p2.setPatientName("Sneha");
        p2.setTreatmentCost(50000);

        p2.patientDetails();
    }
}