#include <stdio.h>
#include <stdlib.h>

#define Elemtype int

//错误码 
#define PARAM_ERROR -1
#define NOTFIND  -2
#define MALLOC_ERROR  -3  
#define CANNOT_DEL  -4

typedef struct node{
	Elemtype data;
	struct node *next;
}CLNode;

//创建表头节点(该循环链表没有头结点) 
int createList(CLNode **head)
{
	*head = NULL;
	return 0;
}

//查找函数,根据位置查找元素是否存在 
int searchByPos(CLNode *First, int pos, CLNode **p)
{
	CLNode *pTemp;
	int i = 1;
	
	if(First == NULL)
	{
		*p = NULL;
		return 0;
	}
	
	pTemp = First;
	
	while(i < pos)
	{
		i++;
		pTemp = pTemp->next;
	}
	
	if(i == pos)
	{
		*p = pTemp;
		return 0;
	}
	else if(i == 0)
	{
		*p = NULL;
		return 0;
	} 
	else
	{
		return NOTFIND;
	}
	
}

//根据位置插入值
int insertValue(CLNode **First, int pos, Elemtype value)
{
	CLNode *pNew = NULL;
	CLNode *pTemp = NULL;
	
	pNew = (CLNode *)malloc(sizeof(CLNode));
	if(pNew == NULL)
	{
		return MALLOC_ERROR;
	}
	
	pNew->data = value;
	pNew->next = NULL;
	
	searchByPos(*First, pos-1, &pTemp);
	
	if(pTemp == NULL)
	{
		pNew->next= pNew;  
		*First = pNew; 
		 
	}
	else
	{
		pNew->next = pTemp->next;
		pTemp->next = pNew;
	}
	
	return 0;
}

//获取链表长度
int getLenth(CLNode *First)
{
	CLNode *pTemp;
	int i = 0;
	
	if(First == NULL)
	{
		return i;
	}	
	
	pTemp = First;
	
	do
	{
		i++;
		pTemp = pTemp->next;	
	}while(pTemp != First);	
	
	return i;
}

//头插
int insertHead(CLNode **First, Elemtype value) 
{
	int flag;
	
	flag = insertValue(First, 1, value);
	
	return flag;
}

//尾插
int insertTail(CLNode **First, Elemtype value) 
{
	int flag,len;
	
	len = getLenth(*First);
	
	flag = insertValue(First, len+1, value);
	
	return flag;
}

//指定位置删除元素
int delValue(CLNode *First, int pos)
{
	CLNode *pTemp1 = NULL;
	CLNode *pTemp2 = NULL;
	int flag;

	if(First == NULL)
	{
		return CANNOT_DEL;
	}	
	
	pTemp1 = First;
	flag = searchByPos(First, pos-1, &pTemp1);
	
	if(flag == NOTFIND )
	{
		return CANNOT_DEL;
	}
	
	pTemp2 = pTemp1->next;
	pTemp1->next = pTemp2->next;
	free(pTemp2);
	
	return 0;
}

//打印链表
int printList(CLNode *First) 
{
	CLNode *pTemp;
	
	if(First == NULL)
	{
		return PARAM_ERROR;
	}
	
	pTemp = First;
	
	do
	{
		printf("%d\n", pTemp->data);
		pTemp = pTemp->next;
	}while(pTemp != First);
	
	return 0;	
}

//销毁链表
int delList(CLNode **First)
{
	CLNode *pTemp1;
	CLNode *pTemp2; 
	
	if(First == NULL)
	{
		return PARAM_ERROR;
	}
	
	pTemp1 = *First;
	
	while(pTemp1->next != NULL)
	{
		pTemp2 = pTemp1;
		pTemp1 = pTemp1->next;
		free(pTemp2);
		pTemp2 = NULL;
	}
	
	free(*First);
	*First = NULL;
	
	return 0;
} 

//约瑟夫环函数
int Joseph(CLNode *First, int n)
{
	int i;
	CLNode *p = NULL;
	CLNode *pTemp = NULL; 
	
	if(First == NULL)
	{
		return PARAM_ERROR;
	}
	
	p = First;
	while(p->next != p)
	{
		for(i = 0; i < n-1; i++)
		{
			p = p->next;
		}
		if(p->next != p)
		{
			pTemp = p->next;
			p->next = pTemp->next;
			free(pTemp);
			pTemp = NULL;
			p = p->next; 
		}
	}
	
	printf("The last is: %d", p->data);
	return 0;
}
 
//测试函数
int main()
{
	CLNode *p = NULL;
	int len;
	
	createList(&p);
	
	insertValue(&p, 1, 1);
	insertValue(&p, 2, 2);
	insertValue(&p, 3, 2);
	insertValue(&p, 4, 4);
	insertValue(&p, 5, 5);
	insertValue(&p, 6, 6);
	
	printList(p);
	
	len = getLenth(p);
	printf("len: %d\n", len);
	
	Joseph(p, 3);
	
} 

