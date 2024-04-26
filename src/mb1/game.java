package mb1;

public class game {
	
public int[][]masplay;
public int[][]masbot;

public boolean bothod; 
public int endg;

public boolean bom1 ;

	public game(){
		masplay=new int[10][10];
		masbot=new int[10][10];
	}
	
	public void start() {
		for(int i =0; i<10;i++)
			for(int j=0; j<10;j++){
				
				masplay[i][j]=0;
				masbot[i][j]=0;
				
			}
		
		bothod=false;  
		endg=0;
		
		rasstan(masplay);
		rasstan(masbot);
			
		bom1=false;
		
	}
	
	private boolean testmaspoz(int i,int j){
		return(i>=0 && i<=9 && j>=0 && j<=9);
	}
	
	private void setmasvalue(int [][] mas,int i,int j,int val){
		
		if(testmaspoz(i,j)) mas [i][j]= val;
		
	}
	private void setorkr(int [][] mas,int i,int j,int val){
	
		if(testmaspoz(i, j)&& mas[i][j]==0)     setmasvalue(mas, i, j, val);	
	}
	private void okrbegin(int [][] mas,int i,int j,int val){
		setorkr(mas, i-1, j-1, val);
		setorkr(mas, i-1, j, val);
		
		setorkr(mas, i-1, j+1, val);
		setorkr(mas, i ,  j+1, val);
		
		setorkr(mas, i+1, j+1, val);
		
		setorkr(mas, i+1, j, val);
		setorkr(mas, i+1, j-1, val);
		setorkr(mas, i,   j-1, val);
	}
	
	private void make1p(int[][] mas){
		
		for(int cun = 1; cun<=4; cun++){
			while (true){
				int i = (int)(Math.random()*10);
				int j = (int)(Math.random()*10);
				
				if(mas[i][j]==0){
					
				 mas[i][j]=1;
				 okrbegin(mas, i, j, -1);
				 break;
				}
			}
		}
	}
	private void okrend(int[][] mas){
		for(int i =0; i<=9;i++){
			for(int j = 0; j<=9;j++){
				if(mas[i][j]==-2)mas[i][j]=-1;
			}
		}
	}
	
	private boolean testnu(int[][] mas, int i,int j){
		if(testmaspoz(i, j)== false)return false;
		if(mas[i][j]==0 || mas[i][j]==-2)return true;
		else return false;
		 
	}
	
	private void make4p(int[][] mas,int kolpaluba){
		while(true){
			
			boolean flag=false;
			
			
	int i=0,j=0;
 i = (int)(Math.random()*10);
 j = (int)(Math.random()*10);
	
// mas[i][j]=4;

 int napr = (int)(Math.random()*4);
 if(testnu(mas, i, j)==true){

	
	if(napr==0){
		if(testnu(mas, i-(kolpaluba-1), j)==true)flag=true; 
		
	}
	else
		if(napr==1){
			if(testnu(mas, i, j-(kolpaluba-1))==true)flag=true; 
		}
		else
			if(napr==2){
				if(testnu(mas, i+(kolpaluba-1), j)==true)flag=true;
			}
			else
				if(napr==3){
					if(testnu(mas, i, j+(kolpaluba-1))==true)flag=true;
				}
 } if(flag==true){
	 
	  mas[i][j]=kolpaluba;
	  okrbegin(mas,i, j, -2);
	 
if(napr==0){
	for(int k=kolpaluba-1; k>=1;k--){
	mas[i-k][j]=kolpaluba; okrbegin(mas, i-k, j, -2); 
	}}
else if(napr==1){
	for(int k=kolpaluba-1; k>=1;k--){
	mas[i][j-k]=kolpaluba; okrbegin(mas, i, j-k, -2); 
	}}
else if(napr==3){
	for(int k=kolpaluba-1; k>=1;k--){
	mas[i][j+k]=kolpaluba; okrbegin(mas, i, j+k, -2); 
}}
else if(napr==2){
	for(int k=kolpaluba-1; k>=1;k--){
	mas[i+k][j]=kolpaluba; okrbegin(mas, i+k, j, -2);

      } 
	}
break;
}
 
		} 
		
okrend(mas);
}
	  private void rasstan(int [][] mas) {
		
		 make4p(mas,4);
		 for(int i=0; i<=1;i++){
			 make4p(mas,3);
		 }
		 for(int i=0; i<=2;i++){
			 make4p(mas,2);
		 }
	  
	make1p(mas);

	}
	  
	  public void vistrplay(int i,int j){
		  
		  masbot[i][j]+=7;
		  testkill(masbot,i,j);
		  victori();
				  
		  if(masbot[i][j]<8){
			  bothod=true;
		     while(bothod){
		    	 bothod = bothod();
		     }
		  }
		  
	  }
	  //победитель 
	  private void victori(){
		 final int testnumber =330;
		  int colbot = 0;
		  int colpleayr = 0;
		  
		  for(int i=0; i<10;i++){
			for(int j=0;j<10;j++){
				if(masbot[i][j]>=15)colbot+=masbot[i][j];
				if(masplay[i][j]>=15)colpleayr+=masplay[i][j];
			}
		  }
		  if(colbot== testnumber)endg=1;
		  else if(colpleayr== testnumber)endg=2;
	  }
	  
	  //установк одн элем забора подбитого карабля
	  
	  private void setokrpodbit (int[][]mas,int i,int j){
		  if(testmaspoz(i, j)){
			  if(mas[i][j]==-1 || mas[i][j]==6)mas[i][j]--;
			  
			  
			  	  
		  }
	  }
	  
	  //окр заборам 1й паулбы
	  private void okrpodit(int mas[][],int i,int j){
	   setokrpodbit(mas, i-1, j-1);
	   setokrpodbit(mas, i-1, j);
	   setokrpodbit(mas, i-1, j+1);
	   setokrpodbit(mas, i, j+1);
	   setokrpodbit(mas, i+1, j+1);
	   setokrpodbit(mas, i+1, j);
	   setokrpodbit(mas, i+1, j-1);
	   setokrpodbit(mas, i, j-1);
	  }
	  
	  
	   //ход бота
	  private boolean bothod(){
		  boolean rez= false ;
		  boolean flag=false;
		  
	     m1:for(int i=0;i<10;i++){
	    	 for(int j=0;j<10;j++){
		      if(masplay[i][j]>=9 && masplay[i][j]<=11){
		    		  
		    		  flag=true;
		    		//выстрел верх
		    		  if(testmaspoz(i-1, j)&&(masplay[i-1][j]<=4 && masplay[i-1][j]!=-2)){  
		    			  masplay[i-1][j]+=7;
		    			  testkill(masplay,i-1,j);
		    			  
		    			if(masplay[i-1][j]>=8) {
		    				rez=true;}	
		    				break m1;
	
		    			  
		    			  
		    			  
		    			  
		    		  }else 			    		  
			    		  if(testmaspoz(i+1, j)&&(masplay[i+1][j]<=4 && masplay[i+1][j]!=-2)){	
			    			  masplay[i+1][j]+=7;
			    			  testkill(masplay,i+1,j);
			    			  
			    			if(masplay[i+1][j]>=8) {
			    				rez=true;}		
			    				break m1;

			    			
			    			
			    			

			    	  }else if(testmaspoz(i, j-1)&&(masplay[i][j-1]<=4 && masplay[i][j-1]!=-2)){  
			    			  masplay[i][j-1]+=7;
			    			  testkill(masplay,i,j-1);
			    			  
			    			if(masplay[i][j-1]>=8) {
			    				rez=true;}		
			    				break m1;

			    			
			    			


		    		  }else  if(testmaspoz(i, j+1)&&(masplay[i][j+1]<=4 && masplay[i][j+1]!=-2)){ 
			    			  masplay[i][j+1]+=7;
			    			  testkill(masplay,i,j+1);
			    			  
			    			if(masplay[i][j+1]>=8) {
			    				rez=true;}		
			    				break m1;

		    		  }
		    	  }
		      }
	     }
	      if(!flag){
	    	  for(int k=0;k<100;k++){
	    		 int i= (int)(Math.random()*10);
	    		 int j= (int)(Math.random()*10);
	    		 
	    		 if(masplay[i][j]<=4 && masplay[i][j]!=-2){
	    			 
	    		 
		    			  masplay[i][j]+=7;
		    			  testkill(masplay,i,j);
		    			if(masplay[i][j]>=8) rez=true;
		    	
		    			flag=true;
		    			break;
	    		 }
	    	  }
	    		 
	    	  }
	    	  
	      if(flag==false){
	    	m2: 
	    		for(int i=0;i<10;i++){
	    		  for(int j=0;j<10;j++){
	    			  
	    			  if(masplay[i][j]<=4 && masplay[i][j]!=-2){

	 		    			  masplay[i][j]+=7;
	 		    			  testkill(masplay,i,j);
	 		    			if(masplay[i][j]>=8) rez=true;

	 		    			break m2;
	 	    		 }
	    		  }
	    		  }
	    	  }
	      
	      
	      
	      victori();
		  return rez;
	  }
		      private void testkill (int[][]mas,int i,int j){
		    	  
		    	  //1
		    	  if(mas [i][j]==8){
		    		  mas [i][j]+=7;
		    		  okrpodit(mas, i, j);
		    	  }
		    	  
		    	  //2
		    	  else if(mas [i][j]==9)analizubit(mas,i,j,2);
		    	  
		    	  //3
		    	  else if(mas [i][j]==10)analizubit(mas,i,j,3);
		    	  //4 
		    	  else if(mas [i][j]==11)analizubit(mas,i,j,4);
		    	  }
		      private void analizubit(int[][]mas,int i,int j,int kolpalub){
		    	  int kolranen=0;
		    	  for(int k=i-(kolpalub-1);k<=i+(kolpalub+1);k++){
		    		  for(int m=j-(kolpalub-1);m<=j+(kolpalub+1);m++){
		    			  if(testmaspoz(k, m)&& mas[k][m]==kolpalub+7)kolranen++;
		    		  }
		    	  }
		    	  //сравнение 
		    	 if(kolpalub==kolranen) {
		    		      for(int k=i-(kolpalub-1);k<=i+(kolpalub+1);k++){
			    		  for(int m=j-(kolpalub-1);m<=j+(kolpalub+1);m++){
			    			  if(testmaspoz(k, m)&& mas[k][m]==kolpalub+7)  mas [k][m]+=7; okrpodit(mas, k, m);
			    			  
			    		  }
			    	  }
		    	 }
		      }
		      
		    
		      
          }
	  
	 