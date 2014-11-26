$(function() {
    var dialog, form,

    // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
    //    emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
    //    name = $( "#name" ),
    //    email = $( "#email" ),
    //    password = $( "#password" ),
        title = $( "#title" ),
        url = $( "#url" ),
        note = $( "#note" ),
        ban = $( "#ban" ),
        allFields = $( [] ).add( title ).add( url ).add( note).add( ban ),
        tips = $( ".validateTips" );

    function updateTips( t ) {
        tips
            .text( t )
            .addClass( "ui-state-highlight" );
        setTimeout(function() {
            tips.removeClass( "ui-state-highlight", 1500 );
        }, 500 );
    }

    //function checkLength( o, n, min, max ) {
    //    if ( o.val().length > max || o.val().length < min ) {
    //        o.addClass( "ui-state-error" );
    //        updateTips( "Length of " + n + " must be between " +
    //        min + " and " + max + "." );
    //        return false;
    //    } else {
    //        return true;
    //    }
    //}
    //
    //function checkRegexp( o, regexp, n ) {
    //    if ( !( regexp.test( o.val() ) ) ) {
    //        o.addClass( "ui-state-error" );
    //        updateTips( n );
    //        return false;
    //    } else {
    //        return true;
    //    }
    //}

    function reload(data) {
        $( "#links tbody" ).clear;
        $.each(data.items, function( i, item ) {
            $( "#links tbody" ).append( "<tr>" +
            "<td>" + item.title + "</td>" +
            "<td>" + item.url + "</td>" +
            "<td>" + item.note + "</td>" +
            "<td>" + item.ban + "</td>" +
            "</tr>" );
        });

        //$( "#links tbody" ).append( "<tr>" +
        //"<td>" + title.val() + "</td>" +
        //"<td>" + url.val() + "</td>" +
        //"<td>" + note.val() + "</td>" +
        //"<td>" + ban.val() + "</td>" +
        //"</tr>" );
    }

    function addLink() {
        var valid = true;
        allFields.removeClass( "ui-state-error" );

        //valid = valid && checkLength( name, "username", 3, 16 );
        //valid = valid && checkLength( email, "email", 6, 80 );
        //valid = valid && checkLength( password, "password", 5, 16 );
        //
        //valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
        //valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
        //valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

        if ( valid ) {
            //$( "#links tbody" ).append( "<tr>" +
            //"<td>" + title.val() + "</td>" +
            //"<td>" + url.val() + "</td>" +
            //"<td>" + note.val() + "</td>" +
            //"<td>" + ban.val() + "</td>" +
            //"</tr>" );

            //$.ajax({
            //    type: "GET",
            //    url: "/link/add",
            //    data: allFields,
            //    success: reload,
            //    //dataType: dataType
            //});
            $.getJSON(
                "/link/add",
                allFields//
                //reload
                )
                .done(function( data ) {
                        $( "#links tbody" ).empty();
                        $.each(data, function( item ) {
                            $( "#links tbody" ).append( "<tr>" +
                            "<td>" + data[item].title + "</td>" +
                            "<td>" + data[item].url + "</td>" +
                            "<td>" + data[item].note + "</td>" +
                            "<td>" + data[item].ban + "</td>" +
                            "</tr>" );
                        });
                    });
            dialog.dialog( "close" );
        }
        return valid;
    }

    dialog = $( "#dialog-form" ).dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            "Create an account": addLink,
            Cancel: function() {
                dialog.dialog( "close" );
            }
        },
        close: function() {
            form[ 0 ].reset();
            allFields.removeClass( "ui-state-error" );
        }
    });

    form = dialog.find( "form" ).on( "submit", function( event ) {
        event.preventDefault();
        addLink();
    });

    $( "#create-link" ).button().on( "click", function() {
        dialog.dialog( "open" );
    });
});