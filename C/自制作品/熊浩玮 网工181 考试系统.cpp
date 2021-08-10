#include<stdio.h>
#include<windows.h>
void fun1();
void fun2();
void fun3(); 

int main()
{
	int start;
	int choice;
	int answer;
	int i;
	
	printf("欢迎进入随堂测试系统!\n(按回车继续)\n");
	getchar();
	printf("您准备好了吗？准备好了请按1,未准备好请输入0\n");
	printf("请输入:");
	scanf("%d",&start);
	
	if(start==0)
	    printf("\n欢迎下次使用!\n");
	else
	{
	printf("\n这是本测试的题目,请思考并解答:\n"); 
	printf("\n************************************************\n\n");
	printf("1、输出*形图案\n");
	printf("2、输出任意区间内的素数\n");
	printf("3、给三个数求其水仙花数\n");
	printf("4、退出\n"); 
	printf("\n************************************************\n\n");
	
    printf("查看答案请按1,退出请按0:");
    scanf("%d",&answer);
    if(answer==0)
        printf("\n欢迎下次使用!\n");
        
	else
	{
	for(i=1;;i++)
	{
	printf("\n请输入选择解答的选项:"); 
	scanf("%d",&choice);  
	
	if(choice==1)
	{
		int x;
		system("CLS");
		printf("第一题答案公布:\n");
		fun1();
		
		printf("\n\n退出请按0，继续解题请按1:"); 
		scanf("%d",&x);
		if(x==0)
		{
		    printf("欢迎下次使用!\n");
		    break;
	    }
	}
	
	if(choice==2)
	{
		int x;
		system("CLS");
		printf("第二题答案公布:\n");
		fun2();
		
		printf("\n\n退出请按0，继续解题请按1:"); 
		scanf("%d",&x);
		if(x==0)
		{
		    printf("欢迎下次使用!\n");
		    break;
	    }
	}
	
	if(choice==3)
	{
		int x;
		system("CLS");
		printf("第三题答案公布:\n");
		fun3();
		
		printf("\n\n退出请按0，继续解题请按1:"); 
		scanf("%d",&x);
		if(x==0)
		{
		    printf("欢迎下次使用!\n");
		    break;
	    }
	}
	
	if(choice==4) 
	{ 
	    printf("\n欢迎下次使用!\n");
	    break;
	} 
    } 
    }
    }       	
} 

void fun1()
{
	int i,j;
	int n;
	
	printf("Input n:");
	scanf("%d",&n);
	
	for(i=1;i<=n;i++)
	{
		for(j=1;j<=n-i;j++)
		{
			printf(" ");
		}
		printf("%c",'A'+i-1);
		if(i==1)
		{
			printf("\n");
			continue;
		}
		
		for(j=1;j<=2*i-3;j++)
		{
			printf(" ");
		}
		printf("%c",'A'+i-1);
		printf("\n");
	}
	
	for(i=1;i<n;i++)
	{
		for(j=1;j<=i;j++)
		{
			printf(" ");
		}
		printf("%c",'A'+n-i-1);
	    if(i==n-1)
		{
			printf("\n");
			break;
		}
		
		for(j=1;j<=2*(n-i)-3;j++)
		{
			printf(" ");
		}
		
		printf("%c",'A'+n-i-1);
		printf("\n");
	}
}

void fun2()
{
	long a,b;
	long n,i;
	long count=0;
	long flag=0;
	
	printf("从小到大输入两个数，作为你需要的区间：");
	scanf("%ld%*c%ld",&a,&b);
	printf("您输入的区间为[%ld,%ld]\n",a,b);

	for(n=a;n<=b;n++)  
	{
	   for(i=2;i<n;i++)
	   {
		  if(n%i==0)
		    break;
		  else if(i==n-1)
		    flag=1;    
	   }
	     
		  if(flag==1)
		  {
		     printf("%7ld",n);
		     count++;
		     flag=0;
		  if(count%10==0)
	         printf("\n"); 	
		  }
	         
    }
}

void fun3()
{
	int a,b,c,result;
	printf("Input a,b,c:");
	scanf("%d%*c%d%*c%d",&a,&b,&c);
	if(a>9||b>9||c>9)
	  printf("error!because the number will be the 0~9\n");
	else 
	  printf("result=%d=%d*%d*%d+%d*%d*%d+%d*%d*%d",result=a*a*a+b*b*b+c*c*c,a,a,a,b,b,b,c,c,c);
} 
