/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ContatosTableModel extends AbstractTableModel {

    private List lista;
    private String[] nomes;

    public ContatosTableModel(List l) {
        lista = l;
        nomes = new String[]{"Nome", "Telefone", "Email"};
    }

    public ContatosTableModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return getLista().size();
    }

    @SuppressWarnings("static-access")
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contatos p = (Contatos) getLista().get(rowIndex);

        if (columnIndex == 0) {
            return p.getNome();
        }
        if (columnIndex == 1) {
            return p.getTelefone();
        }
        if (columnIndex == 2) {
            return p.getEmail();
        }

        return p.getNome();
    }

    @Override
    public String getColumnName(int column) {
        return nomes[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 0) {
            return Integer.class;
        }
        if (columnIndex == 3) {
            return Double.class;
        }
        return String.class;
    }

    public Contatos getContato(int indice) {
        return (Contatos) getLista().get(indice);
    }

    public List getLista() {
        return lista;
    }

    public void inserir(Contatos p) {
        getLista().add(p);
        fireTableDataChanged();
    }

    public void atualizar(Contatos atualiza, int index) {
        getLista().set(index, atualiza);
        fireTableDataChanged();
    }

    public void excluir(int pos) {
        lista.remove(pos);

        fireTableDataChanged();
    }

    public void excluir(Contatos p) {
        lista.remove(p);
        fireTableDataChanged();
    }

    public void excluirTudo() {
        lista.removeAll(lista);
        fireTableDataChanged();
    }

    /**
     *
     * @param tabela
     */
    public void getPosicionamento(JTable tabela) {
        DefaultTableCellRenderer rendererCentro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rendererDireita = new DefaultTableCellRenderer();
        DefaultTableCellRenderer rendererEsquerda = new DefaultTableCellRenderer();

        rendererCentro.setHorizontalAlignment(SwingConstants.CENTER);
        rendererDireita.setHorizontalAlignment(SwingConstants.RIGHT);
        rendererEsquerda.setHorizontalAlignment(SwingConstants.LEFT);

        TableColumnModel modeloDaColuna = tabela.getColumnModel();

        modeloDaColuna.getColumn(0).setCellRenderer(rendererEsquerda);
        modeloDaColuna.getColumn(1).setCellRenderer(rendererEsquerda);
        modeloDaColuna.getColumn(2).setCellRenderer(rendererEsquerda);
       
    }
        public void acaoAdicionar(){
        ContatosTableModel tela = new ContatosTableModel(lista);
        tela.setVisible(true);
    }
    
    public void acaoSair(){
         System.exit(0);
    }
       public void setVisible(boolean bln) {
        // compiled code
    }
}
