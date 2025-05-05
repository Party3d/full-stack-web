#!/bin/bash

set -e

echo "🧼 Atualizando pacotes..."
sudo apt update && sudo apt upgrade -y

echo "📦 Instalando dependências..."
sudo apt install -y ca-certificates curl gnupg lsb-release

echo "🔐 Adicionando chave GPG do Docker..."
sudo mkdir -p /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg |   sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg

echo "📦 Adicionando repositório Docker ao APT..."
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] \
  https://download.docker.com/linux/ubuntu \
  $(lsb_release -cs) stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

echo "📥 Atualizando repositórios..."
sudo apt update

echo "🐳 Instalando Docker Engine, CLI e Compose..."
sudo apt install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

echo "✅ Verificando versões instaladas..."
docker --version
docker compose version

echo "👤 Adicionando usuário ao grupo docker..."
sudo usermod -aG docker $USER

echo ""
echo "✅ Instalação concluída com sucesso!"
echo "ℹ️ Saia e entre novamente na sessão ou execute: newgrp docker"
echo "🚀 Para testar, execute: docker run hello-world"
