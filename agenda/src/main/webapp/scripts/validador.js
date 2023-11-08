/**
 * 
 */

 function validar(){
	 let nome = frmContato.nome.value
	 let fone = frmContato.fone.value
	 
	 if(nome === ""){
		 alert('Preencha o corpo nome')
		 frmContato.nome.focus()
		 return false
	 }else if(fone === ""){
		 alert('Preencha o corpo Fone')
		 frmContato.nome.focus()
		 return false
	 }
 }