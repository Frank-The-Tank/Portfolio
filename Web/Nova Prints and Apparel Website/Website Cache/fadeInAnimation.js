document.ready(function(){
    $('body').css('display', 'none');
    $('body').fadeIn(3000);
    $('mainButton').click(function() {
        event.preventDefault();
        newLocation = this.href;
        $('body').fadeOut('3000', 'newpage');
    });
        function newpage() {
    window.location = newLocation
        }

    });