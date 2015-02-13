package framesystem;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import lib.Calculation_lib;
import lib.MM1_lib;
import lib.MMS_lib;

public class FrameSystemView extends Frame implements ActionListener,WindowListener{
	
	private TextField text1 = new TextField("",5);
	private TextField text2 = new TextField("",5);
	private TextField text3 = new TextField("",5);
	private Button button1 =new Button("足し算");
	//M/m/1用
	private TextField m1 = new TextField("",5);
	private TextField m2 = new TextField("",5);
	private TextField m3 = new TextField("",5);
	private Button bm =new Button("M/M/1");
	//M/M/S用
	private TextField mms1 = new TextField("",5);
	private TextField mms2 = new TextField("",5);
	private TextField mms3 = new TextField("",5);
	private TextField mms4 = new TextField("",5);
	private TextField mms5 = new TextField("",5);
	private TextField mms6 = new TextField("",5);
	private TextField mms7 = new TextField("",5);
	private TextField mms8 = new TextField("",5);
	private TextField mms9= new TextField("",5);
	private Button bmms =new Button("M/M/S");
	
	
	public FrameSystemView(FrameSystemController controller) {
		// TODO Auto-generated constructor stub
		addWindowListener(this);
		setTitle("FrameSystem");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(text1);
		add(text2);
		add(button1);
		add(new Label("答え"));
		add(text3);
		//M/M/1用
		add(new Label("λ"));
		add(m1);
		add(new Label("μ"));
		add(m2);
		add(bm);
		add(new Label("平均系内人数"));
		add(m3);
		//M/M/S用
		add(new Label("λ"));
		add(mms1);
		add(new Label("μ"));
		add(mms2);
		add(new Label("s"));
		add(mms3);
		add(new Label("r"));
		add(mms4);
		add(bmms);
		add(new Label("利用率"));
		add(mms5);
		add(new Label("平均待ち人数"));
		add(mms6);
		add(new Label("平均系内人数"));
		add(mms7);
		add(new Label("平均待ち時間"));
		add(mms8);
		add(new Label("平均系内時間"));
		add(mms9);
		button1.addActionListener(this);
		bm.addActionListener(this);
		bmms.addActionListener(this);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button1){
		int val1=Integer.parseInt(text1.getText());
		int val2=Integer.parseInt(text2.getText());
		//text3.setText(String.valueOf(val1+val2));
		Calculation_lib clib =  new Calculation_lib(val1,val2);
		text3.setText(String.valueOf(clib.getPlus()));
		}
		else if(e.getSource()==bm){
			double lambda=Double.parseDouble(m1.getText());
			double mu=Double.parseDouble(m2.getText());
			MM1_lib mlib = new MM1_lib(lambda,mu);
			m3.setText(String.valueOf(mlib.getLength()));
			}
		else if(e.getSource()==bmms){
			double lambda=Double.parseDouble(mms1.getText());
			double mu=Double.parseDouble(mms2.getText());
			int s=Integer.parseInt(mms3.getText());
			int r=Integer.parseInt(mms4.getText());
			MMS_lib mms = new MMS_lib(lambda,mu,s,r);
			
			mms5.setText(String.valueOf(mms.getRho()));
			mms6.setText(String.valueOf(mms.getLq()));
			mms7.setText(String.valueOf(mms.getL()));
			mms8.setText(String.valueOf(mms.getWq()));
			mms9.setText(String.valueOf(mms.getW()));
			}
	}
}