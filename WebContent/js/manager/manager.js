$(document).ready(function()
{
	//$(".btn-delete").click(function()
	//{
        //var id = $(".btn-delete").parent().children(":first");//第一个子节点
        //alert( id.text());
	//});
});

function delete_manager(obj)
{
    //var id = obj.parent().children(":first");//第一个子节点
    var id = $(obj).parent().children(":first");
    
    alert( id.text());
};

function add_manager(obj)
{
	alert("add");
    //var id = $(obj).parent().children(":first");
    
    //alert( id.text());
};
