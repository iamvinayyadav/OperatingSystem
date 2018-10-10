#include<iostream>
#include<numeric>
using namespace std;
int main()
{
	int nop;
	cin>>nop;
	int p[nop+1][5];
	string name[nop+1][4];
	name[0][0]="Process";
	name[0][1]="BT";
	name[0][2]="CT";
	name[0][3]="TAT";
	name[0][4]="WT";
	cin>>p[1][1];
	p[1][3]=p[1][2] = p[1][1];
	p[1][4]=p[1][3] - p[1][1];
	for(int i=2;i<=nop;i++)
	{
		cin>>p[i][1];
		p[i][3]=p[i][2]=p[i-1][1]+p[i][1];
		p[i][4]=p[i][3] - p[i][1];
	}
	float avg_wt,avg_tat,sum1=0,sum2=0;
	for(int i=1;i<=nop;i++)
	{
		avg_wt = (sum1 + p[i][4])/nop;
		avg_tat = (sum2 + p[i][3])/nop;
	}
	for(int i=0;i<=nop;i++)
	{
		for(int j=0; j<=4; j++)
		{
			if(i==0)
			cout<<name[0][j]<<"\t";
			else
			{
			if(j==0)
			cout<<"P"<<i<<"\t";
			else
			cout<<p[i][j]<<"\t";
			}	
		}
		cout<<endl;
	}
	cout<<"Average Turn Around Time = "<<avg_tat<<endl;
	cout<<"Average Waiting Time = "<<avg_wt;
}
