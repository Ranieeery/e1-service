-- 1° - Conectar nos bancos presentes no arquivo liquibase-config.json

-- 2° - Crie um script com o usuário STG5PINHAIS e execute a query abaixo para listar as versões
SELECT * FROM DATABASECHANGELOG
ORDER BY DATEEXECUTED DESC

-- 3° - Encontre a versão para rollback e execute a query abaixo substituindo pela tag alvo
DELETE FROM DATABASECHANGELOG
WHERE TAG = 'stg5-tag'

-- 4° - Verifique se foi realizado utilizando a query do passo 1

-- 5° - Com o usuário PINHAIS, execute o comando abaixo com a tag a ser apagada
SELECT * FROM DATABASECHANGELOG
WHERE TAG = 'stg5-tag'
ORDER BY DATEEXECUTED DESC 	

-- 6° - Encontrado, execute a query abaixo trocando a tag em SET para a última versão em STG5PINHAIS antes do erro
UPDATE DATABASECHANGELOG
SET TAG = 'stg5-stg5pinhais.tag'
WHERE TAG = 'stg5-tag'
