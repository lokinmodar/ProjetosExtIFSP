


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import static java.awt.Color.BLUE;
import static java.awt.Color.RED;


public class NomeSobrenomeForm extends javax.swing.JFrame {
    private JTextField jTextFieldNome;
    private JTextField jTextFieldSobrenome;
    private JButton buttonOK;
    private JPanel jFormPanel;
    private JLabel jLabelNome;
    private JLabel jLabelSobrenome;
    private JTextField jTextFieldIdade;
    private JLabel jLabelIdade;
    private ArrayList<Pessoa> nomes = new ArrayList<>();


    private NomeSobrenomeForm() {
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa pessoa = new Pessoa();
                try {
                    Integer.parseInt(jTextFieldIdade.getText());
                    if (jTextFieldNome.getText().isEmpty() || jTextFieldSobrenome.getText().isEmpty() || jTextFieldIdade.getText().isEmpty()) {
                        JOptionPane
                                .showMessageDialog(
                                        JOptionPane.getRootFrame()
                                                .getParent(), "O usuário precisa preencher nome, sobrenome e idade",
                                        "Erro de leutura",
                                        JOptionPane.ERROR_MESSAGE);
                    } else {
                        String msg = "Bem-vindo " + jTextFieldNome.getText() + " " + jTextFieldSobrenome.getText();
                        JOptionPane
                                .showMessageDialog(
                                        JOptionPane.getRootFrame()
                                                .getParent(), msg,
                                        "Bem-vindo",
                                        JOptionPane.INFORMATION_MESSAGE);

                        pessoa.setNome(jTextFieldNome.getText());
                        pessoa.setSobrenome(jTextFieldSobrenome.getText());
                        pessoa.setIdade(Integer.parseInt(jTextFieldIdade.getText()));

                        nomes.add(pessoa);

                        for (Pessoa p : nomes) {
                            System.out.println(p.toString());
                        }
                    }


                } catch (NumberFormatException exception) {
                    JOptionPane
                            .showMessageDialog(
                                    JOptionPane.getRootFrame()
                                            .getParent(), "Digite uma idade válida!",
                                    "Erro de leutura",
                                    JOptionPane.ERROR_MESSAGE);
                }


                //.getNome()+" "+p.getSobrenome()+" "+String.valueOf(p.getIdade()));
            }
            //jLabelNome.setForeground(BLUE);
            //jTextFieldNome.setBackground(RED);


        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NomeSobrenomeForm");
        frame.setContentPane(new NomeSobrenomeForm().jFormPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
