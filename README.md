# 🎵 Alura Music

[![Java](https://img.shields.io/badge/Java-21-%23ED8B00?logo=openjdk)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-%236DB33F?logo=spring)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-%23316192?logo=postgresql)](https://www.postgresql.org/)
[![Gemini API](https://img.shields.io/badge/Gemini_API-1.5-%23FF6F00?logo=google)](https://ai.google.dev/)

Um App musical interativo via terminal com **Spring Boot** e integração à **API do Gemini** para enriquecer dados de artistas.

## ✨ Funcionalidades

- **🎤 Cadastro de artistas e músicas** (persistidos em PostgreSQL)
- **🔍 Consultas personalizadas** (listagem por artista, gênero, etc.)
- **🤖 Busca inteligente** (obtenha biografias e curiosidades via Gemini AI)
- **🖥️ Menu intuitivo** (interface 100% terminal)

## 🛠️ Tecnologias

- **Backend:** Java 21, Spring Boot 3, Spring Data JPA
- **Banco de Dados:** PostgreSQL
- **IA:** Gemini API (Google AI)
- **Ferramentas:** Hibernate, Maven

## ⚙️ Como Executar

1. **Pré-requisitos:**
   - Java 17+
   - PostgreSQL 16+
   - Chave de API do Gemini ([obtenha aqui](https://ai.google.dev/))

2. **Configuração:**
   ```bash
   git clone https://github.com/marcioluca/aluraMusic.git
   cd aluraMusic
   ```
   - Crie um arquivo `.env` na raiz com:
     ```
     DB_URL=jdbc:postgresql://localhost:5432/alura_music
     DB_USERNAME=seu_user
     DB_PASSWORD=sua_senha
     GEMINI_API_KEY=sua_chave
     ```

3. **Execução:**
   ```bash
   mvn spring-boot:run
   ```

## 🤝 Contribuições

Contribuições são bem-vindas! Abra uma **issue** ou envie um **PR** com melhorias.

## 📄 Licença

Este projeto está sob licença MIT. Veja o arquivo [LICENSE](LICENSE) para detalhes.
```
