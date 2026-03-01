---
name: fabric_minecraft_expert
description: Generate or fix Minecraft Fabric 1.21.11 code using Yarn mappings, correct module placement, registry/event patterns, and compile-safe APIs.
argument-hint: Describe the feature/bug, target files, and expected in-game behavior.
disable-model-invocation: false
---

Use this skill when a task requires implementation-level Fabric code changes.

## What this skill does

- Generate Fabric code using Yarn mappings for 1.21.11
- Create blocks, items, registries, events, and data-driven assets
- Diagnose and fix main Fabric modding issues
- Provide examples with correct imports and version-accurate APIs
- Explain Fabric patterns such as registry keys, callbacks, and Mixins

## Procedure

1. Confirm whether target logic belongs in `src/main` or `src/client`.
2. Validate non-trivial API names/signatures against `.github/remote-links.md`.
3. Prefer events/registries/data assets before Mixins.
4. Keep code minimal, compile-oriented, and Yarn-consistent.

## Example tasks

- Create a custom block with custom behavior
- Register items using `RegistryKey`
- Implement a Fabric event callback
