(function(){
    $("#tabclientes").on("click",".js-delete", function(){
        let botaoClicado = $(this);
        $("#btnsim")
            .attr("data-id", botaoClicado.attr("data-id"));
        $("#modalcliente").modal("show");

        });

        $("#btnsim").on("click",function(){
            let botaoSim = $(this);
            let id = botaoSim.attr("data-id");
            $.ajax(
                {
                    url: "/clientes/remover/" + id,
                    method: "GET",
                    success: function(){
                        window.location.href = "/clientes";
                    }
                }
            ); 
        });




        
        $("#tabprodutos").on("click",".js-delete", function(){
            let botaoClicado = $(this);
            $("#btnsim")
                .attr("data-id", botaoClicado.attr("data-id"));
            $("#modalproduto").modal("show");
    
            });
    
            $("#btnsim").on("click",function(){
                let botaoSim = $(this);
                let id = botaoSim.attr("data-id");
                $.ajax(
                    {
                        url: "/produtos/remover/" + id,
                        method: "GET",
                        success: function(){
                            window.location.href = "/produtos";
                        }
                    }
                ); 
            });


            $("#taborcamentos").on("click",".js-delete", function(){
                let botaoClicado = $(this);
                $("#btnsim")
                    .attr("data-id", botaoClicado.attr("data-id"));
                $("#modalorcamento").modal("show");
        
                });
        
                $("#btnsim").on("click",function(){
                    let botaoSim = $(this);
                    let id = botaoSim.attr("data-id");
                    $.ajax(
                        {
                            url: "/produtos/remover/" + id,
                            method: "GET",
                            success: function(){
                                window.location.href = "/produtos";
                            }
                        }
                    ); 
                });
    
    

        
})();