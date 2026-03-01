---
name: web_researcher
description: Validate Fabric/Yarn APIs and mappings with official docs, then synthesize practical implementation guidance for the current workspace.
argument-hint: Include the API/class/method to validate and the target Minecraft/Fabric versions.
disable-model-invocation: false
---

Use this skill when API accuracy is uncertain or version drift is likely.

## What this skill does

- Validate Yarn names and Fabric API usage
- Compare Mixin injection strategies
- Identify changes across Fabric API versions
- Pull examples from reputable sources and synthesize them

## Source priority

1. `.github/remote-links.md`
2. Official Fabric/Yarn docs and mappings
3. Reputable examples only when official references are insufficient

## Example tasks

- Find updated Fabric API methods for 1.21.11
- Compare `@Inject` vs `@ModifyVariable`
- Summarize best practices for registry creation
