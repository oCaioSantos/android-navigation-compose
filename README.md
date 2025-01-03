### Pré-requisitos

- Android Studio Flamingo ou mais recente.
- Conhecimento básico em Jetpack Compose e Kotlin.

## 📁 Estrutura do Projeto

- **`MainActivity`**: Configura a navegação e o tema.
- **`App`**: Define o `NavHost` e gerencia as rotas.
- **`ScreenA`**: Tela inicial com botão para navegar para `ScreenB`.
- **`ScreenB`**: Tela que exibe um ID recebido como argumento e permite retornar à `ScreenA`.
- **Rotas**: Implementadas com objetos (`@Serializable`) para facilitar o compartilhamento de dados.

## 📖 Detalhes de Implementação

### Navegação entre telas

As rotas são definidas como objetos serializáveis, como mostrado abaixo:

```kotlin
@Serializable
object RouteScreenA

@Serializable
data class RouteScreenB(val id: Int)
```

Ao navegar, os dados podem ser passados diretamente como argumentos:

```kotlin
navController.navigate(RouteScreenB(id = 1))
```

E na tela de destino, os argumentos são recuperados:

```kotlin
val (id) = it.toRoute<RouteScreenB>()
```

### Uso do `NavHost`

O `NavHost` conecta as rotas e seus respectivos composables:

```kotlin
NavHost(
    navController = navController,
    startDestination = RouteScreenA
) {
    composable<RouteScreenA> {
        ScreenA(navController)
    }
    composable<RouteScreenB> {
        val (id) = it.toRoute<RouteScreenB>()
        ScreenB(navController, id)
    }
}
```

## 🖥️ Telas

1. **Screen A**: Tela inicial com um botão para navegar para a próxima tela (`Screen B`).
2. **Screen B**: Exibe um ID recebido como parâmetro e permite voltar para a tela anterior.

## 🔧 Tecnologias Utilizadas

- **Jetpack Compose**: Interface declarativa para Android.
- **Kotlin Serialization**: Para criar rotas dinâmicas e serializáveis.
- **Material3**: Componentes visuais modernos.

## 🌟 Contribuindo

Sinta-se à vontade para abrir issues e pull requests para contribuir com melhorias neste projeto.

---

Desenvolvido com ❤️ usando Jetpack Compose.
```
