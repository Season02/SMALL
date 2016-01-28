function nextPage(servlet,total,current) 
{
	if(total==current)
	{
		
	}
	else
	{
		current=parseInt(current)+1;
		window.location=servlet + "?action=data_gather_next&page="+current;
	}
}

function previousPage(servlet,total,current) 
{
	if('1'==current)
	{
		
	}
	else
	{
		current=parseInt(current)-1;
		window.location=servlet + "?action=data_gather_next&page="+current;
	}
}

function firstPage(servlet,total,current) 
{
	if('1'==current)
	{
		
	}
	else
	{
		current=parseInt(1);
		window.location=servlet + "?action=data_gather_next&page="+current;
	}
}

function lastPage(servlet,total,current) 
{
	if(total==current)
	{
		
	}
	else
	{
		current=parseInt(total);
		window.location=servlet + "?action=data_gather_next&page="+current;
	}
}
