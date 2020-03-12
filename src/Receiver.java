public class Receiver implements Runnable {
  private int id;
  private int pac_no;
  private Paczkomat paczkomat;

  Receiver(int id, int pac_no, Paczkomat paczkomat){
    this.id = id;
    this.pac_no = pac_no;
    this.paczkomat = paczkomat;

    System.out.println("Reciever No. " + this.id + " is in parcel locker No. "+ paczkomat.getPaczkomat_no());
  }

  int getId(){
    return id;
  }

  @Override
  public void run() { paczkomat.getPackage(paczkomat, pac_no, id); }
}
