
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Cuenta
{
    private String codCuenta= "cta-";
    private double saldo;
    private String nombreCuentaHabiente;
    private String fechaCreacion;
    private int cantDepositosRealizados;
    private int cantRetirosExitososRealizados;
    private static int cantCuentasCreadas = 0;
    
    
    public Cuenta (double pSaldo){
        this(null,pSaldo);
        
    }
    
    
    public Cuenta (String nombreCuentaHabientP, double pSaldo){
        saldo=pSaldo;
        this.nombreCuentaHabiente=nombreCuentaHabientP;
        fechaCreacion= fechaCuentaCreada();
        cantDepositosRealizados=0;
        cantRetirosExitososRealizados=0;
        cantCuentasCreadas++;
        codCuenta = codCuenta + cantCuentasCreadas;
    }
    
    
    
    //Esto lo tuve que agregar para obtener la fecha pero no venía en el diagrama------------
    private String fechaCuentaCreada() { 
        Date fecha = new Date(System.currentTimeMillis()); 
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy HH:mm:ss"); 
        return formatoFecha.format(fecha); 
    }
    //---------------------------------------------------------------------------------------
    
    public void setnombreCuentaHabiente(String pnombreCuentaHabiente){
        nombreCuentaHabiente = pnombreCuentaHabiente;
    }
    
    
    public String getCodCuenta(){
        return codCuenta;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public double depositar(double monto){
        saldo += monto;
        cantDepositosRealizados++;
        return saldo;
    }
    
    public double retirar(double monto){
        if (validarRetiro(monto)){
            saldo-=monto;
            cantRetirosExitososRealizados++;
        }
        return saldo;
    }
    
    private boolean validarRetiro (double monto){
        return monto<=saldo; 
        }
    
    
    
    public static int getCantCuentasCreadas(){
        return cantCuentasCreadas;
    }
    
    public String toString(){
        String msg = "";
        msg += "-----Estado de cuenta-----\n";
        msg += "Código: " + codCuenta + "\n"; 
        msg += "Nombre: " + nombreCuentaHabiente + "\n";
        msg += "Fecha de creado: " + fechaCreacion + "\n"; 
        msg += "Saldo: " + saldo + "\n"; 
        msg += "Depositos realizados: " + cantDepositosRealizados + "\n"; 
        msg += "Retiros exitosos: " + cantRetirosExitososRealizados + "\n";
        
        return msg;
    }

}














