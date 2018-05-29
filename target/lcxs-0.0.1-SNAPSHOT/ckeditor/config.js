/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	config.toolbar = 'my';
	config.removeDialogTabs = 'image:advanced;image:Link';//取消链接和高级两个按钮
	var strFullPath=window.document.location.href;  
	var strPath=window.document.location.pathname;  
	var pos=strFullPath.indexOf(strPath);  
	var prePath=strFullPath.substring(0,pos);  
	//获取带"/"的项目名，如：/uimcardprj
	var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);  
    config.filebrowserImageUploadUrl = prePath+postPath+'/img/uploadImg'; //tomcat路径
	config.image_previewText=' '; //预览区域显示内容
	config.toolbar_my = [
	['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Image','HorizontalRule','Smiley','SpecialChar'],
	'/',
	['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
	['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
	'/',
	['Font','FontSize'],
	['TextColor','BGColor']
	];
};
