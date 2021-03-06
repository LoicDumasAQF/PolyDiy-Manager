package graphic.ui.seller;
/**
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */


import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import graphic.engine.AbstractUI;
import graphic.engine.UIMessage;
import logic.facade.FacadeEditProfil;

public class UpdateSellerUI extends AbstractUI {
		 private JTextField nameShop;
		 private JLabel label;
		 private JTextField description; 
		 private JLabel label1; 
		 JTextField siret; 
		 private JLabel label2;
		 JTextField website; 
		 private JLabel label3;
		 JButton cancel = new JButton();
		 JButton update = new JButton();
	
	public UpdateSellerUI(UIMessage communication) {
		super(communication);
			//this.nameShop.setPreferredSize(new Dimension(150, 30));
		this.panel.setLayout(null);
		label = new JLabel("Name of Shop");
		this.label.setBounds(123, 80, 86, 14);
		this.panel.add(label);
		nameShop = new JTextField();
		this.nameShop.setBounds(219, 80, 182, 20);
		this.panel.add(nameShop);
		//this.description.setPreferredSize(new Dimension(150, 30));
		description = new JTextField();
		this.description.setBounds(219, 120, 182, 20);
		label1 = new JLabel("Description"); 
		this.label1.setBounds(123, 120, 86, 14);
		this.panel.add(this.label1);
		this.panel.add(this.description);
		//this.siret.setPreferredSize(new Dimension(150, 30));
		siret = new JTextField();
		this.siret.setBounds(219, 160, 182, 20);
		label2 = new JLabel("Siret");
		this.label2.setBounds(123,160,86, 14);
		this.panel.add(this.label2);
		this.panel.add(this.siret);
		//this.website.setPreferredSize(new Dimension(150, 30));
		website = new JTextField();
		this.website.setBounds(219, 200, 182, 20);
		label3 = new JLabel("Website");
		this.label3.setBounds(123,200,86, 14);
		this.panel.add(this.label3);
		this.panel.add(this.website);
		this.update.setText("Update");
		
		//this.update.setPreferredSize(new Dimension(150, 30));
		 this.update.setBounds(143, 240, 120, 30);
		 this.panel.add(this.update);		
		this.update.addActionListener(this);
		this.cancel.setText("Cancel");
		//this.cancel.setPreferredSize(new Dimension(150, 30));
		this.cancel.setBounds(340, 240, 120, 30);
		this.panel.add(this.cancel);
		this.cancel.addActionListener(this);
		this.panel.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		FacadeEditProfil facade = new FacadeEditProfil((int)this.communication.getElement("id_account"));
		try {
			if (arg0.getSource()==update){
			facade.createSeller((int)this.communication.getElement("id_account"), this.nameShop.getText(), this.description.getText(), this.siret.getText(), this.website.getText());
			facade.Validate();
			this.setChanged();
			this.notifyObservers("seller");
			}
			if (arg0.getSource()== cancel){
				this.setChanged();
				this.notifyObservers("seller");
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
