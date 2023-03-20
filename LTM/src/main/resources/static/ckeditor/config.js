/**
 * @license Copyright (c) 2003-2022, CKSource Holding sp. z o.o. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.editorplaceholder = '내용을 입력해주세요😊';
	config.extraPlugins = 'uploadimage';
	config.uploadUrl = 'user/imageUpload.do';
	config.filebrowserUploadUrl = 'user/imageUpload.do';
};
