var t=setTimeout("mostrarFecha()",1000);

function mostrarFecha()
{
 	var now = new Date();
	document.getElementById("hora").innerHTML= "Son las: " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
	setTimeout("mostrarFecha()",
		/*Descomentar la siguiente línea para quitar el error*/
		1000
	);
}
