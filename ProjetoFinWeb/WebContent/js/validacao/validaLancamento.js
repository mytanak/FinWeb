            $(document).ready( function() {
                $("#formLancamento").validate({
                    rules:{
                    	codConta:{
                            required: true
                        },
                        codOperacao:{
                            required: true
                        },
                        codModalidade:{
                            required: true
                        },
                        codFornecedor:{
                            required: true
                        },
                        dataVencimento:{
                            required: true
                        },
                        valor:{
                            required: true
                        }
                    },
                    messages:{
                    	codConta:{
                            required: "Selecione uma conta"
                        },
                        codOperacao:{
                            required: "Selecione uma despesa/receita"
                        },
                        codModalidade:{
                            required: "Selecione uma modalidade de pagamento/recebimento"
                        },
                        codFornecedor:{
                            required: "Selecione um fornecedor"
                        },
                        dataVencimento:{
                            required: "Informe a data de vencimento"
                        },
                        valor:{
                            required: "Informe o valor"
                        }
                    }
                });
            });
