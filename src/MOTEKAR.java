public class MOTEKAR {
    String NamaRekening;
    String NoRekening;
    String NamaBank;
    String Nominal;
    String Keterangan;
    
    
    public MOTEKAR(String x, String y,String D, String z, String p){
        this.NamaRekening= x;
        this.NoRekening = y;
        this.NamaBank = D;
        this.Nominal= z;
        this.Keterangan= p;
        
    }
    
    public String getNamaRekening(){
        return NamaRekening;
    }
    
    public String getNoRekening(){
        return NoRekening;

    }

    public String getNamaBank(){
        return NamaBank;
    }

    public String getNominal(){
        return Nominal;
    }    

    public String getKeterangan(){
        return Keterangan;    

    }

    
}


