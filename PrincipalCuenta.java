
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalCuenta
{
    public static void main(String[] arg) {
        Scanner sc= new Scanner (System.in);
        List<Cuenta> cuentas=new ArrayList <>();
        int actual = -1;
        
        System.out.println("======================================");
        System.out.println("             Clase Cuenta");
        System.out.println("======================================");
        
        
        boolean salir = false;
        while (!salir){
            System.out.println("\nMenú principal");
            System.out.println("1) Crear cuenta");
            System.out.println("2) Cantidad de cuentas creadas");
            System.out.println("3) Listar cuentas");
            System.out.println("4) Seleccionar cuenta actual");
            System.out.println("5) Asignar el nombre del cuenta habiente");
            System.out.println("6) Depositar");
            System.out.println("7) Retirar");
            System.out.println("8) Consultar saldo");
            System.out.println("9) Consultar estado de cuenta (toString)");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();
            
            switch (op) {
                //Crear 
                case "1": {
                    System.out.print("Nombre del cuenta habiente(enter para asignarlo después): ");
                    String nombre = sc.nextLine().trim();
                    System.out.print("Saldo inicial: ");
                    double saldoInicial = sc.nextDouble();//Uso
                    sc.nextLine();
                    
                    Cuenta r;
                    if (nombre.isEmpty()) {
                        r = new Cuenta(saldoInicial);
                    } else {
                        r = new Cuenta(nombre, saldoInicial);
                    }
                    cuentas.add(r);
                    actual = cuentas.size() - 1;
                    System.out.println("Cuenta creada y seleccionado (índice " + actual + ").");
                    break;
                }
                
                //Cantiodad de cuentas
                case "2": {
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cuentas creadas.");
                        break;
                    }  
                    System.out.println("Cuentas creadas: " + Cuenta.getCantCuentasCreadas());   
                    break;
                    
                }
                //Listar cuentas
                case "3": {
                    if (cuentas.isEmpty()) {
                        System.out.println("No hay cunetas creadas.");
                    } else {
                        for (int i = 0; i < cuentas.size(); i++) {
                            Cuenta c = cuentas.get(i);
                            System.out.println("Índice: " + i + " | Código: "
                                    + c.getCodCuenta() + " | Saldo: " + c.getSaldo());
                        }
                }
                }
                
                //Seleccionar cuenta
                case "4": {
                    if (cuentas.isEmpty()) {
                        System.out.println("Cree una cuenta primero.");
                        break;
                    }
                    System.out.print("Índice de la cuenta a seleccionar: ");
                    String idxS = sc.nextLine().trim();
                    try {
                        int idx = Integer.parseInt(idxS);
                        if (idx >= 0 && idx < cuentas.size()) {
                            actual = idx;
                            System.out.println("Cuenta índice " + actual + " seleccionado.");
                        } else {
                            System.out.println("Índice fuera de rango.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Índice inválido.");
                    }
                    break;
                    
                }
                //Asignar nombre
                case "5": {
                    if(actual==-1){
                        System.out.println("Primero debes seleccionar una cuenta");
                        break;
                    } 
                    System.out.println("Nombre del cuenta habiente");
                    String nombre = sc.nextLine().trim();
                    cuentas.get(actual).setnombreCuentaHabiente(nombre);
                    System.out.println("Nombre asignado");
                }
                //Depositar
                case "6": {
                     if(actual==-1){
                        System.out.println("Primero debes seleccionar una cuenta");
                    } else{
                        System.out.println("Monto a depositar");
                        double monto = sc.nextDouble();
                        sc.nextLine();
                        
                        double nuevoSaldo = cuentas.get(actual).depositar(monto);
                         System.out.println("Nuevo monto: "+ nuevoSaldo);
                    }
                    break;
                }
                //Retirar
                case "7": {
                    if(actual==-1){
                        System.out.println("Primero debes seleccionar una cuenta");
                        break;
                    } 
                    System.out.println("Monto a depositar");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    double nuevoSaldo = cuentas.get(actual).retirar(monto);
                    System.out.println("Nuevo monto: "+ nuevoSaldo);
                    break;
                }
                //Consultar 
                case "8": {
                    if(actual==-1){
                        System.out.println("Primero debes seleccionar una cuenta");
                        break;
                    } 
                    System.out.println("Saldo actual: " + cuentas.get(actual).getSaldo());
                    break;
                }
                //Estado
                case "9": {
                    if(actual==-1){
                        System.out.println("Primero debes seleccionar una cuenta");
                        break;
                    } 
                    System.out.println(cuentas.get(actual).toString());
                    break;
                }
                //SAlir
                case "0": {
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                }
                default:
                    System.out.println("Opción invalida");
            }
            
            
            
            
            
            
            
            
            
        }
        sc.close();
    }
}