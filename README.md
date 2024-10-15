# Tech Challenge - 8SOAT

## Descrição
Este projeto foi desenvolvido como parte do Tech Challenge - 8SOAT pelos alunos Kaique e Milton.  
O objetivo é gerenciar uma rede de fast food com gerenciamento de produtos e pedidos.

## Miro com a documentação
Acesse o Miro com a documentação do projeto:  
[Documentação Miro](https://miro.com/app/board/uXjVKsqfDCM=/?share_link_id=397605018551)

## Tecnologias Utilizadas
- **Backend:** Java 17, Spring Boot, JPA, Hibernate
- **Banco de dados:** MySQL
- **Outras:** Docker

## Como Executar
Para executar o projeto com Docker Compose, siga as instruções abaixo:

```bash
docker-compose up -d
```

## Swagger
Acesse o Swagger do projeto para visualizar a documentação da API:

[Swagger](http://localhost:8080/swagger-ui/index.html#)

---

# Instruções de Deploy

## 1 - Executar applys no Kubernetes
Para aplicar as configurações no Kubernetes, execute os seguintes comandos:

```bash
kubectl apply -f service.yaml
kubectl apply -f mysql-deployment.yaml
kubectl apply -f hpa-deployment.yaml
kubectl apply -f deployment.yaml
kubectl apply -f https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
```

### Configuração do Metrics Server

Para habilitar o `insecure-tls` no Metrics Server:

```bash
kubectl patch deployment metrics-server -n kube-system --type='json' \
-p='[{"op": "add", "path": "/spec/template/spec/containers/0/args/-", "value": "--kubelet-insecure-tls"}]'
```

### 2 - Encaminhar porta 8080
Para acessar a aplicação localmente na porta 8080:

```bash
kubectl port-forward svc/app-pdv-service 8080:8080
```

---

## 3 - Comandos úteis para desenvolvimento e configurações

### 3.1 - Listar Pods
Para listar os pods no namespace `kube-system`:

```bash
kubectl get pods -n kube-system
```

Para visualizar os logs do Metrics Server:

```bash
kubectl logs metrics-server-587b667b55-hrrzv -n kube-system
```

Para listar todos os pods:

```bash
kubectl get pods
```

### 3.2 - Verificar Services
Para listar os serviços ativos:

```bash
kubectl get services
```

### 3.3 - Verificar Horizontal Pod Autoscalers (HPA)
Para listar os HPAs:

```bash
kubectl get hpa
```

### 3.4 - Deletar Deployments
Para deletar os deployments:

```bash
kubectl delete deployment app-pdv-app
kubectl delete deployment mysql
```

### 3.5 - Verificar e deletar Services, HPAs e Ingress
Para listar serviços e ingressos:

```bash
kubectl get svc
kubectl get ingress
```

Para deletar serviços e HPAs:

```bash
kubectl delete svc mysql
kubectl delete svc app-pdv-app
kubectl delete hpa
kubectl delete ingress app-pdv-app-ingress
```

---

## Helm

### Criar, empacotar e instalar o Helm Chart

1. Criar um Helm Chart:

   ```bash
   helm create app-pdv
   ```

2. Empacotar o Helm Chart:

   ```bash
   helm package app-pdv
   ```

3. Instalar o Helm Chart empacotado:

   ```bash
   helm install app-pdv-0.1.0.tgz --generate-name
   ```

4. Listar as releases do Helm:

   ```bash
   helm list
   ```

5. Desinstalar o Helm Chart:

   ```bash
   helm uninstall app-pdv-0-1728932168
   ```

6. Instalar novamente o Helm Chart:

   ```bash
   helm install app-pdv-0.1.0.tgz --generate-name
   ```

