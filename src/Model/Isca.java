
package Model;

import DAO.IscaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class Isca {
    static  SimpleDateFormat modelo = new SimpleDateFormat("dd/MM/yyyy");

    public static String modeloData(Date calendario) {
        return modelo.format(calendario.getTime()).toString();
    }
    public static Date ConverterStringParaDate(String str){
            Date data = new Date();
        try {
            data= modelo.parse(str);
            System.out.println(data);
        } catch (ParseException ex) {
            Logger.getLogger(Isca.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return data;
    }
    private int codigo;
    private boolean status;
    private int ID;
    private String  iccid;
    private String dataAtivacao;
    private String dataCriacao;
    private String Cliente;
    private String operadora;
    private String tipo;
    
    public static ArrayList<Isca> lista = new ArrayList<Isca>();
    
    
    public Isca(ArrayList<Isca> lista){
        this.lista = lista;
        update();
    }

    public Isca() {
        
    }

    public Isca(boolean status,int id,String iccid, String cliente,String DataAtivacao,String operadora,String tipo) {
    this.status = status;
    this.ID=id;
    this.iccid = iccid;
    this.Cliente = cliente;
    this.dataAtivacao = DataAtivacao;
    this.operadora = operadora;
    this.tipo = tipo;
   /* if(!PesquisarIsca(id)){
    Gravar();
        
    }else{
        JOptionPane.showMessageDialog(null,"A isca "+id+"ja esta cadastrada");
    }*/
    
    }

    public Isca(boolean status, int id, String iccid, String cliente, String dataAtivacao, String operadora, String tipo,String dataCriacao) {
        this.status = status;
        this.ID = id;
        this.iccid = iccid;
        this.Cliente = cliente;
        this.dataAtivacao = dataAtivacao;
        this.operadora = operadora;
        this.tipo = tipo;
        this.dataCriacao = dataCriacao;
    }
    
    
    public static ArrayList<Isca> getLista() {
        return lista;
    }

    public Isca(int id, String iccid, String Cliente, String Operador, String Tipo) {
        this.ID = id;
        this.iccid = iccid;
        this.Cliente = Cliente;
        this.operadora = Operador;
        this.tipo= Tipo;
    }

    
   
    

   

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(String dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


   
   

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

   

    public String getCliente() {
        return Cliente;
    }

   
    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    @Override
    public String toString() {
        return "Isca{" + "codigo=" + codigo + ", status=" + status + ", ID=" + ID + ", iccid=" + iccid + ", dataAtivacao=" + getDataAtivacao() + ", dataCriacao=" + getDataCriacao() + ", Cliente=" + Cliente + ", operadora=" + operadora + ", tipo=" + tipo + '}';
    }

  public boolean Alterar(){
      IscaDAO dao = new IscaDAO();
      if(dao.Alterar(this)){
          return true;
      }else{
          return false;
      }
  }
   
    public boolean PesquisarIsca(int id){
        IscaDAO dao = new IscaDAO();
        if (dao.pesquisa("id", String.valueOf(id),"igual")){
            return true;
        }else{
            return false;
        }
    }
    public boolean update(){
        IscaDAO dao = new IscaDAO();
        if (dao.update(this)){
            return true;
        }else{
            return false;
        }
    }
    public boolean Gravar(){
        IscaDAO d = new IscaDAO();
        if(d.create(this) == 0){
            
            return false;
        }else{
            
            return true;
        }
        /*
        List<Integer> duplicado = new ArrayList<Integer>();
        for(int i=0;i<lista.size();i++){
        if (d.pesquisa("id",String.valueOf(lista.get(i).getID()),"igual") != null){
            duplicado.add(lista.get(i).getID());
            lista.remove(i);
            
        }  
        int codigo = d.create(this);
       
        
        if (codigo >0){
            JOptionPane.showMessageDialog(null,"Salvo com sucesso");
             lista.removeAll(lista);
        } 
        else {
            if (duplicado.size() >0){
                String str=null;
                for (int j=0;j<duplicado.size();j++) {
                    str = "+"+duplicado.get(j).toString();
                   
                }
                JOptionPane.showMessageDialog(null,"as seguintes iscas ja possuem cadastro"+str);
                lista.removeAll(lista);
            }
            
            
        }
        
        }*/
        
    }
    public static DefaultTableModel getTableModelTodosAtivos(){
        IscaDAO dao = new IscaDAO();
        
        List<Isca> lista = dao.read();
        List<Isca> resp = dao.read();
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("STATUS");
        model.addColumn("ID");
        model.addColumn("ICCID");
        model.addColumn("CLIENTE");
        model.addColumn("DATA");
        model.addColumn("OPERADORA");
        model.addColumn("TIPO");
        
        
        for (int i=0;i<lista.size();i++){
            String status;
            if (lista.get(i).isStatus()){
                status = "Ativo";
                resp.add(lista.get(i));
                
            String[] reg = {status,String.valueOf(resp.get(i).getID()),resp.get(i).getIccid().toString(),resp.get(i).getCliente(),String.valueOf(resp.get(i).getDataAtivacao()),resp.get(i).getOperadora(),resp.get(i).getTipo()};
            model.addRow(reg);
            }else{
                status = "Inativo";
            }
            
        }
        return model;
    }
    
   public static DefaultTableModel getTableIscaCancelar(){
       System.out.println("rodouuuuuuuuuu");
       IscaDAO dao = new IscaDAO();
        List<Isca> lista = dao.read();
        List<Isca> listaAtiva = new ArrayList<Isca>();
        List<Isca> listaCancelar = new ArrayList<Isca>();
        
        for (int i=0;i<lista.size();i++)
        {
           
            if (lista.get(i).isStatus())
            {
                
                listaAtiva.add(lista.get(i));
            }    
          
        }
        SimpleDateFormat padrao = new SimpleDateFormat("dd/MM/yyyy");
        for(int i =0 ; i<listaAtiva.size();i++)
        {
            
           try {
               Date data  = padrao.parse(listaAtiva.get(i).getDataAtivacao());
               GregorianCalendar condicional = new GregorianCalendar();
               
               condicional.add(Calendar.DAY_OF_MONTH, -31);
               
                if (condicional.getTime().getTime()> data.getTime()){
                    listaCancelar.add(listaAtiva.get(i));
                }
               
           } catch (ParseException ex) {
               Logger.getLogger(Isca.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        DefaultTableModel model= new DefaultTableModel();
       
        model.addColumn("ID");
        model.addColumn("ICCID");
        model.addColumn("CLIENTE");
        model.addColumn("DATA");
        model.addColumn("OPERADORA");
        model.addColumn("TIPO");
        for(int i=0;i<listaCancelar.size();i++){
            
        System.out.println(listaCancelar.get(i).getDataAtivacao());
        String[] reg = {String.valueOf(listaCancelar.get(i).getID()),listaCancelar.get(i).getIccid().toString(),listaCancelar.get(i).getCliente(),String.valueOf(listaCancelar.get(i).getDataAtivacao()),listaCancelar.get(i).getOperadora(),listaCancelar.get(i).getTipo()};
        model.addRow(reg);
        }
        return model;
   }
    
    public static DefaultTableModel getTableModel(){
        IscaDAO dao = new IscaDAO();
        List<Isca> lista = dao.read();
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("STATUS");
        model.addColumn("ID");
        model.addColumn("ICCID");
        model.addColumn("CLIENTE");
        model.addColumn("DATA");
        model.addColumn("OPERADORA");
        model.addColumn("TIPO");
        
        
        for (Isca i:lista){
            String status;
            if (i.isStatus() || i.getDataAtivacao() != null){
                status = "Ativo";
            }else{
                status = "Inativo";
                i.setDataAtivacao("");
            }
            
            String[] reg = {status,String.valueOf(i.getID()),i.getIccid().toString(),i.getCliente(),String.valueOf(i.getDataAtivacao()),i.getOperadora(),i.getTipo()};
            model.addRow(reg);
        }
        return model;
    }
    public static DefaultTableModel getTableModelPesquisa(String coluna,String r){
        IscaDAO dao = new IscaDAO();
        List<Isca> aaa = dao.findByCodigo(coluna, r);
        DefaultTableModel model= new DefaultTableModel();
        model.addColumn("STATUS");
        model.addColumn("ID");
        model.addColumn("ICCID");
        model.addColumn("CLIENTE");
        model.addColumn("DATA CRIACAO");
        model.addColumn("OPERADORA");
        model.addColumn("TIPO");
        for (Isca i:aaa){
            String status;
            if (i.isStatus()){
                status = "Ativo";
            }else{
                status = "Inativo";
            }
            String[] reg = {status,String.valueOf(i.getID()),i.getIccid(),i.getCliente(),i.getDataAtivacao(),i.getOperadora(),i.getTipo()};
            model.addRow(reg);
        }
        
        return model;
    }
    
    public boolean ExcluirIsca(int Isca){
        IscaDAO dao = new IscaDAO();
        boolean resp = dao.delete(Isca);
        if (resp){
            System.out.println("A isca foi excluida com sucesso");
            return true;
        }else{
            System.out.println("Nao foi possivel excluir a isca"+ID);
            return false;
        }
    }
    public boolean Desativar(int isca){
        IscaDAO dao = new IscaDAO();
        if(dao.Desativar(isca)){
            return true;
        }else{
            return false;
        }
    }
    
    public List<Isca> pegarValores(String id){
        IscaDAO dao = new IscaDAO();
        List<Isca> lista = new ArrayList<Isca>();
        lista = dao.findByCodigo("ExatoID", id);
        return lista;
    }

  
    
}
