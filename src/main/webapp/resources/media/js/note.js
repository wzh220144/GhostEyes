$(function(){
    
	//parameter represent how many times list1 has been click
    var c = 0;
    
    //parameter represents which list is used
    var curList = 0;
	
    //in the beginning, hide some buttons
    $("#usrid").hide();
    $("#save").hide();
    $("#edit").hide();
    $("#recycle").hide();
    $("#note-meta").hide();
    
	//resize function
    $( window ).resize(function() {	
    
    });
    
    //*************************************function****************************************//
    
    //get time from time stamp
    function   formatDate(stamp)   {
    	var now = new Date(stamp);
    	var year = now.getFullYear();     
        var month = now.getMonth()+1;     
        var date = now.getDate();     
        var hour = now.getHours();     
        var minute = now.getMinutes();     
        var second = now.getSeconds();     
        return   year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second; 
    }     
    
    //add abstract block
    function add_abstract(abstract, id, title, lastEditTime, createTime) {

        $(abstract).append('<div class = "note-list-content abstract" id = "' + id + '"></div>');
        var nid = abstract + ' #' + id;
        $(nid).append('<div>' + title + '</div>');
        $(nid).append('<div>Last edit time:' + formatDate(lastEditTime) + '</div>');
        $(nid).append('<div>create time:' + formatDate(createTime) + '</div>');
        $(nid).click(function() {      //click the abstract, then you can see the whole content in content area
        	$("#edit").show();
            $("#recycle").show();
            $("#note-meta").show();
            $("#curNoteId").val(id);
            $.getJSON("/ghosteyes/note/" + id + ".json", function(data) {
            	var note = data.note;
            	$("#editor").html(note.content);
            	$("#title").val(note.title);
            	$("#category").val(note.category);
            	$.getJSON("/ghosteyes/notebook/" + note.nbid + ".json", function(data) {
                	var nb = data.notebook;
                	$("#notebook").val(nb.notebook);
                });
            	
        	});
            
        });
    }
    
    //add notebook block
    function add_notebook(notename, id, notebook) {	
        $(notename).append('<tr><td class = "warning notebook" id = "' + id + '">' + notebook + '</td></tr>');
        var nid = notename + ' #' + id;
        $(nid).click(function() {
        	$('#list4').html('');
        	$.getJSON("/ghosteyes/note/title/" + $("#usrid").html() + "/" + id + "/all.json", function(data) {
        		$.each(data.notes, function(i, item) {
        			add_abstract('#list4', item.articleid, item.title, item.lastEditDate, item.createDate);
        		});
        	});
        });
    }
    
    //load notebook to 'list'
    function loadNoteBook() {
    	$('#list4').html('');
    	$('#note-name1').html('');
    	$.getJSON("/ghosteyes/notebook/" + $("#usrid").html() + "/all.json", function(data) {
    		$.each(data.notebooks, function(i, item) {
    			add_notebook('#note-name1', item.nbid, item.notebook);
    		});
    	});
    }
    
    //load notes ordered by time into 'list'
    function loadNotesByTime() {
    	$('#list4').html('');
    	$.getJSON("/ghosteyes/note/" + $("#usrid").html() + "/time.json", function(data) {
    		$.each(data.notes, function(i, item) {
    			add_abstract('#list4', item.articleid, item.title, item.lastEditDate, item.createDate);
    		});
    	});
    }
    
    //load notes put in recycle
    function loadNotesInRecycle() {
    	$('#list4').html('');
    	$.getJSON("/ghosteyes/note/" + $("#usrid").html() + "/recycle.json", function(data) {
    		$.each(data.notes, function(i, item) {
    			add_abstract('#list4', item.articleid, item.title, item.lastEditDate, item.createDate);
    		});
    	});
    }
    
    //refresh
    function refresh(list) {
    	if(list == 1) {
    		loadNoteBook("#note-name1");
    	}
    	else if(list == 2) {
    		loadNotesByTime("#note-name2");
    	}
    	else if(lsit == 3) {
    		loadNotesByTime("#note-name2");
    	}
    }
    
   
    
  //*************************************event triggered by click****************************************//
    
    //the function when hit recycle button
    $("#recycle").click(function() {
    	var id = $("#curNoteId").val();
    	$.ajax({	//send note to server
			type : "POST",
			url : "/ghosteyes/note/recycle/" + id + ".json",
			dataType : "json",
			data : {},
			success : function(data) {		//if success, update page
				
			},
		});
    	refresh(curList);
    });
    
    //the function when hit create button
    $("#create").click(function() {
    	var h = $("#editor").height();
        $("#editor").summernote({height: h});
        $("#edit").hide();
        $("#recycle").hide();
        $("#save").show();
        $("#note-meta").show();
        $("#title").val('');
		$("#category").val('');
		$("#notebook").val('');
		$("#editor").code('');
    });
    
    //the function when hit edit button
    $("#edit").click(function() {
        var h = $("#editor").height();
        var HTML = $("#editor").html();
        $("#editor").summernote({height: h});
        $("#editor").code(HTML);
        $("#edit").hide();
        $("#recycle").hide();
        $("#save").show();
    });
    
    //the function when hit save button
    $("#save").click(function() {		//save a note
    	$.ajax({	//send note to server
			type : "POST",
			url : "/ghosteyes/note.json",
			dataType : "json",
			data : {
				"content":$("#editor").code(),
				"title":$("#title").val(),
				"category":$("#category").val(),
				"notebook":$("#notebook").val(),
				"usrid":$("#usrid").html()
			},
			success : function(data) {		//if success, update page
				
			},
		});
        $("#edit").show();
        $("#recycle").show();
        $("#save").hide();
        $("#editor").destroy();
    });
    
    $("#list1").click(function() {      //Notes sorted by the name of notebook
    	curList = 1;
        c = 1 - c;
        if(c % 2 == 1) {
        	loadNoteBook();
        }
        else {
        	$("#note-name1").html('');
        }
    });
    
     $("#list2").click(function() {     //Notes sorted by time
    	curList = 2;
    	loadNotesByTime();
    });
    
     $("#list3").click(function() {     //Notes put into recylce
    	curList = 3;
        loadNotesInRecycle();
    });
    
});