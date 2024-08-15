import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

class Votes {
    public String voterName;
    public int voterId;

    public int getVoterId() {
        return voterId;
    }

    public Votes(int voterId) {
        this.voterId = voterId;
    }

    public Votes(String voterName) {
        this.voterName = voterName;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterName() {
        return voterName;
    }

    public void printDetails() {
        System.out.println("User has voted with voter id " + voterId);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Nominee {
    public String nomineeName;
    public int nomineeId;

    public int getNomineeId() {
        return nomineeId;
    }

    public Nominee(int nomineeId) {
        this.nomineeId = nomineeId;
    }

    public Nominee(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public void setNomineeId(int nomineeId) {
        this.nomineeId = nomineeId;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

public class DigitalVoting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Nominee, Nominee> nomineeDetails = new HashMap<>();
        HashMap<Votes, Integer> voterDetails = new HashMap<>();
        HashMap<Votes, Votes> userDetails = new HashMap<>();
        Random rand = new Random();

        nomineeDetails.put(new Nominee(1), new Nominee("TRS"));
        nomineeDetails.put(new Nominee(2), new Nominee("BJP"));
        nomineeDetails.put(new Nominee(3), new Nominee("CONGRESS"));
        nomineeDetails.put(new Nominee(4), new Nominee("CPI"));

        System.out.println("Welcome to virtual voting");
        System.out.println("Please enter number of voters");
        int voters = sc.nextInt();

        while (voters != 0) {
            int otp = 1000 + rand.nextInt(9000); // Generate a 4-digit OTP
            System.out.println("Your OTP is: " + otp);

            System.out.println("Enter  Voter's OTP to vote:");
            int enteredOtp = sc.nextInt();

            if (enteredOtp == otp) {
                System.out.println("Enter voter name:");
                String voterName = sc.next();

                System.out.println("Choose whom to vote");
                System.out.println("for TRS enter 1");
                System.out.println("for BJP enter 2");
                System.out.println("for CONGRESS enter 3");
                System.out.println("for CPI enter 4");
                int nomineeId = sc.nextInt();

                Votes v = new Votes(otp);

                if (voterDetails.keySet().contains(v)) {
                    System.out.println("You have already voted");
                } else {
                    voterDetails.put(new Votes(otp), nomineeId);
                    userDetails.put(new Votes(otp), new Votes(voterName));
                }
            } else {
                System.out.println("Invalid OTP. Please try again.");
                continue;
            }
            voters--;
        }

        int trsVotes, bjpVotes, congressVotes, cpiVotes;
        trsVotes = bjpVotes = congressVotes = cpiVotes = 0;

        System.out.println("Displaying TRS party voters: ");
        for (Votes key : voterDetails.keySet()) {
            if (voterDetails.get(key).equals(1)) {
                key.printDetails();
                trsVotes++;
            }
        }

        System.out.println("Displaying BJP party voters: ");
        for (Votes key : voterDetails.keySet()) {
            if (voterDetails.get(key).equals(2)) {
                key.printDetails();
                bjpVotes++;
            }
        }

        System.out.println("Displaying Congress party voters: ");
        for (Votes key : voterDetails.keySet()) {
            if (voterDetails.get(key).equals(3)) {
                key.printDetails();
                congressVotes++;
            }
        }

        System.out.println("Displaying CPI party voters: ");
        for (Votes key : voterDetails.keySet()) {
            if (voterDetails.get(key).equals(4)) {
                key.printDetails();
                cpiVotes++;
            }
        }

        int max = Math.max(trsVotes, Math.max(bjpVotes, Math.max(congressVotes, cpiVotes)));
        int winners = 0;

        if (trsVotes == max) {
            System.out.println("TRS has max votes");
            winners++;
        }
        if (bjpVotes == max) {
            System.out.println("BJP has max votes");
            winners++;
        }
        if (congressVotes == max) {
            System.out.println("Congress has max votes");
            winners++;
        }
        if (cpiVotes == max) {
            System.out.println("CPI has max votes");
            winners++;
        }

        if (winners > 1) {
            System.out.println("Hence it is a draw");
        }
    }
}
