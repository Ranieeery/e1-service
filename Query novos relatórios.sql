-- Query base (procedure)
DECLARE
  V_NOM_PRODUTO                VARCHAR(200) := 'Relatórios';
  V_MENU_PRIMEIRO_NIVEL        VARCHAR(200) := 'Gestão de Pedidos';
  V_PAPEL                      VARCHAR(200) := 'Papel%Admin E1';
BEGIN
  SP_CP_CADASTRO_FUNCIONALIDADE(
  								  V_NOM_PRODUTO,
                                  V_PAPEL,
                                  'Usuários para Pedido de Recarga',
                                  'FUS_MEN_REL_USUARIOS_PEDIDO_RECARGA',
                                  1,
                                  'fa-print',
                                  1,
                                  V_MENU_PRIMEIRO_NIVEL,
                                  'fa-sliders',
                                  'Relatórios',
                                  'fa-print',
                                  'Tela do relatório Usuários para Pedido de Recarga',
                                  '#/order/reports/users-recharge-request-report',
                                  1);
  SP_CP_CADASTRO_URL_SERVICO(V_NOM_PRODUTO,
                               'Usuários para Pedido de Recarga',
                               'FUS_MEN_REL_USUARIOS_PEDIDO_RECARGA',
                               0,
                               'Servico do relatório Usuários para Pedido de Recarga',
                               'api/relatorio/users-recharge-request-report');                            
END;

-- Visualizar informações da query
SELECT * FROM CP_FUS_FUNCIONALIDADE_SISTEMA ORDER BY FUS_ID DESC

-- Visualizar IDs das querys (local e ordem)
SELECT * FROM CP_FUM_FUNCIONALIDADE_MENU ORDER BY FUS_ID DESC

-- Visualizar IDs dos menus no STG5
SELECT * FROM CP_MEP_MENU_PRODUTO ORDER BY MEP_ID 

-- Visualizar IDs de serviço e API dos relatórios
SELECT * FROM CP_CSI_COMPONENTE_SISTEMA
ORDER BY CSI_ID DESC

-- Query personalizada para visualizar relação dos menus
SELECT 
	FUM.FUS_ID ID_MENU,
	FUS.FUS_ID ID_SISTEMA,
	FUS_NOM_FUNCIONALIDADE,
	MEP_ID,
	FUM_NUM_ORDEM ORDEM
FROM
	CP_FUM_FUNCIONALIDADE_MENU FUM,
	CP_FUS_FUNCIONALIDADE_SISTEMA FUS
WHERE FUM.FUS_ID = FUS.FUS_ID
ORDER BY FUS.FUS_ID DESC

-- Modelo da procedure obtido do arquivo 74339.pv-001-create-procedure-SP_CP_CADASTRO_FUNCIONALIDADE.sql
PROCEDURE SP_CP_CADASTRO_FUNCIONALIDADE
(
    NOM_PRODUTO IN VARCHAR2,                -- 'Ponto de Atendimento',  
    NOM_PAPEL IN VARCHAR2,                  -- 'Papel%Cliente',  
    NOM_FUNCIONALIDADE IN VARCHAR2,         -- 'Cadastro de Marca de Veículo', 
    COD_FUNCIONALIDADE IN VARCHAR2,         -- 'FUS_MEN_CADASTRO_MARCA_VEICULO'
    CRIA_FUNCIONALIDADE IN NUMBER,          -- 1,
    TXT_ICONE IN VARCHAR2,                  -- 'fa-window-maximize',
    
    VINCULA_FUNCIONALIDADE_MENU IN NUMBER,  -- cria vinculo com a funcionalidade     
    MENU_PRIMEIRO_NIVEL IN VARCHAR2,        -- informar caso VINCULA_FUNCIONALIDADE_MENU = 1
    TXT_ICONE_PRIMEIRO_NIVEL IN VARCHAR2,   -- icone do 1 nivel caso seja necessario
    MENU_SEGUNDO_NIVEL IN VARCHAR2,         -- informar caso MENU_SEGUNDO_NIVEL = 1
    TXT_ICONE_SEGUNDO_NIVEL IN VARCHAR2,    -- icone do 2 nivel caso seja necssario

    DSC_COMPONENTE IN VARCHAR2,             -- 'Tela Cadastro de Marca de Veículo - Lista',
    TXT_URL_COMPONENTE IN VARCHAR2,         -- '#/cadastros-operacionais/cadastros/marca-veiculo/list',
    IND_ENTRY_POINT IN NUMBER               -- 1
)
PROCEDURE SP_CP_CADASTRO_URL_SERVICO 
(
    NOM_PRODUTO IN VARCHAR2,
    NOM_FUNCIONALIDADE IN VARCHAR2,
    COD_FUNCIONALIDADE IN VARCHAR2,
    CRIA_FUNCIONALIDADE IN NUMBER,
    DSC_COMPONENTE IN VARCHAR2,
    TXT_URL_COMPONENTE IN VARCHAR2 
)

-- Alterar ícone do relatório no STG5:
-- Para alterar o ícone, o primeiro 'fa-print' deve ser trocado para
-- uma fonte disponível em https://fontawesome.com/v4/icons/. Caso
-- escolha o ícone do link https://fontawesome.com/v4/icon/file-text
-- por exemplo, basta copiar o título 'fa-file-text' e substituir
-- no primeiro 'fa-print'
