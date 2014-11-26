$(function() {
    var dialog, form,

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

    function checkLength( o, n, min, max ) {
        if ( o.val().length > max || o.val().length < min ) {
            o.addClass( "ui-state-error" );
            updateTips( "Length of " + n + " must be between " +
            min + " and " + max + "." );
            return false;
        } else {
            return true;
        }
    }

    function checkRegexp( o, regexp, n ) {
        if ( !( regexp.test( o.val() ) ) ) {
            o.addClass( "ui-state-error" );
            updateTips( n );
            return false;
        } else {
            return true;
        }
    }

    function addLink() {
        var valid = true;
        allFields.removeClass( "ui-state-error" );
        valid = valid && checkLength( url, "url", 3, 255 );
        valid = valid && checkRegexp( url, /(([a-z0-9\-\.]+)?[a-z0-9\-]+(!?\.[a-z]{2,4}))/, "eg. ya.ru" );

        if ( valid ) {
            $.getJSON("/link/add", allFields)
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
        height: 360,
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