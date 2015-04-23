$(function(){
    
    $( window ).resize(function() {
    
    });
    
    function add_abstract(abstract, id) {
        $(abstract).append('<div class = "note-list-content abstract" id = "' + id + '"></div>');
        var nid = abstract + ' #' + id;
        $(nid).append('<div>title</div>');
        $(nid).append('<div>date</div>');
        $(nid).append('<div>abstract abstract abstract abstract abstract abstract abstract abstract</div>');
        $(nid).click(function() {      //click the abstract, then you can see the whole content in content area
            var id = $(this).attr('id');
            var html = "";
            $("#editor").html('hehe');
        });
    }
    
    function add_notebook(notename, id) {
        $(notename).append('<tr><td class = "warning notebook" id = "' + id + '">some notes</td></tr>');
        var nid = notename + ' #' + id;
        $(nid).click(function() {
            add_abstract('#list4', id);
        });
    }
    
    $("#save").hide();
    
    $("#edit").click(function() {
        var h = $("#editor").height();
        var HTML = $("#editor").html();
        $("#editor").summernote({height: h});
        $("#editor").code(HTML);
        $("#edit").hide();
        $("#delete").hide();
        $("#save").show();
    });
    
    $("#save").click(function() {
        $("#editor").destroy();
        $("#edit").show()
        $("#delete").show();
        $("#save").hide();
    });
    
    var c1 = 0, c2 = 0, c3 = 0;
    
    $("#list1").click(function() {      //Notes sorted by the name of notebook
        c1 = c1 + 1;
        if(c1 % 2 == 1) {
            add_notebook("#note-name1", "id1");
        }
    });
    
     $("#list2").click(function() {     //Notes sorted by time
        c2 = c2 + 1;
        if(c2 % 2 == 1) {
            add_notebook("#note-name2", "id1");
        }
    });
    
     $("#list3").click(function() {     //Notes put into recylce
        c3 = c3 + 1;
        if(c3 % 2 == 1) {
            add_notebook("#note-name3", "id1");
        }
    });
    
});