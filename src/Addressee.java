import java.util.Random;

public class Addressee implements Runnable {
  private int id;
  private Paczkomat paczkomat;
  private Package aPackage;
  private Receiver receiver;

  Addressee(int id, Paczkomat paczkomat){
    this.id = id;
    this.paczkomat = paczkomat;

    Random rand = new Random();
    aPackage = new Package(rand.nextInt(1000));

    receiver = new Receiver(rand.nextInt(1000),aPackage.getPac_no(),this.paczkomat);

    System.out.println("Addressee No. " + this.id + " is in parcel locker No. "+ paczkomat.getPaczkomat_no());
  }

  @Override
  public void run() {
    final Receiver receiver = paczkomat.putPackage(aPackage, this.receiver);

    if(receiver == null){
      System.out.println();
      System.out.println("Parcel locker No. " + paczkomat.getPaczkomat_no() + " is full");
      return;
    }
    System.out.println("Addressee No. " + id +" is posting a package No. " + aPackage.getPac_no() + " in parcel locker No. "+ paczkomat.getPaczkomat_no() + " to reciever No. " + receiver.getId());
  }
}
