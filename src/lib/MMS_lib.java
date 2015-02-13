package lib;

public class MMS_lib {
	private double lambda,mu,rho,alpha;
	private int s,r;
	
	public MMS_lib(double lambda,double mu,int s,int r){
		this.lambda =lambda;
		this.mu=mu;
		this.alpha = lambda/mu;
		this.rho=this.alpha/s;
		this.s=s;
		this.r=r;
	
	}
	public int getFactorial(int s){
		int f =1;
		for(int i=s;i>=0;i--){
			if(i==0){
				f*=1;
			}else{
				f*=i;
			}
		}
		return f;
		}
	
	public double getP0(){
		double p0=0, p01 =0,p02=0;
		for(int k=0; k<this.s;k++){
			p01+=Math.pow(this.alpha, k)/getFactorial(k);
		}
		p02=Math.pow(this.alpha, this.s)/getFactorial(this.s)/(1-this.rho);
		p0=1/(p01+p02);
		return p0;
	}
	public double getRho(){
		return rho;
	}
	public double getLq(){
		double lq;
		lq=Math.pow(this.s,this.s)*Math.pow(this.rho, this.s+1)*getP0()/getFactorial(this.s)/Math.pow(1-this.rho, 2);
		return lq;
	}
	public double getL(){
		return getLq()+alpha;
		}
	public double getWq(){
		return getLq()/lambda;
	}
	public double getW(){
		return getWq()+1/mu;
	}
	
	public int getConbination(int s ,int r){
		int t =1;
		t=getFactorial(s)/(getFactorial(r)*getFactorial(s-r));
		return t;
	}
	
	}
