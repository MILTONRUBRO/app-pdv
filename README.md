# Tech Challenge - 8SOAT

## Descrição
Este projeto foi desenvolvido como parte do Tech Challenge - 8SOAT. pelos Alunos: Kaique e Milton  
O objetivo é gerenciar uma rede de fast food com gerenciamento de produtos e pedidos

## Miro com a documentação
(https://miro.com/app/board/uXjVKsqfDCM=/?share_link_id=397605018551)

## Tecnologias Utilizadas
* **Backend:** Java 17, SpringBoot, JPA, Hibernate
* **Banco de dados:** MySQL
* **Outras:** Docker

## Como Executar  
Docker Compose  
Na pasta do projeto execute o comando: `docker-compose up -d`

## Swagger
Acessar o link abaixo para ter acesso ao Swagger do projeto  
`http://localhost:8080/swagger-ui/index.html#`




1 - Executar applys

kubectl apply -f service.yaml

kubectl apply -f mysql-deployment.yaml

kubectl apply -f hpa-deployment.yaml

kubectl apply -f deployment.yaml

kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml

Precisamos mudar para insecure-tls para conseguir executar as metricas

kubectl patch deployment metrics-server -n kube-system --type='json' -p='[{"op": "add", "path": "/spec/template/spec/containers/0/args/-", "value": "--kubelet-insecure-tls"}]'


2 - Executar em 1 porta 8080

kubectl port-forward svc/app-pdv-service 8080:8080



3 - Comandos apenas para ajudar no desenvolvimento e configuracoes

3.1 - LISTAR PODS

kubectl get pods -n kube-system

kubectl logs metrics-server-587b667b55-hrrzv     -n kube-system

kubectl get pods


VERIFICAR SERVCICES

kubectl get services


LOGS

kubectl get hpa

kubectl top pod

