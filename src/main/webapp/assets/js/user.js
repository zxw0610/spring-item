function deleteUser(id){
	isDelete = confirm("您确定要删除数据吗");
	if(isDelete){
		window.location.href= 'deleteuser/ '+id;
	}
}
function updateUser(id){
	isDelete = confirm("您确定要修改这条数据吗");
	if(isUpdate){
		window.location.href= 'updateuser/ '+id;
	}
}