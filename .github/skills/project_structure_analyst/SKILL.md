---
name: project_structure_analyst
description: Determine correct placement and boundaries for code/resources in split-source Fabric projects (src/main vs src/client).
argument-hint: Provide the class/resource intent and the target package/module you are considering.
disable-model-invocation: false
---

Use this skill when deciding where new code belongs or when correcting module boundary violations.

## What this skill does

- Determine correct module placement for new or existing classes
- Separate client-only logic (rendering, screens, particles) from shared logic
- Suggest refactors to maintain clean module boundaries
- Ensure generated code respects the project’s architecture

## Decision rules

- Rendering/UI/input/visual effects -> `src/client`
- Gameplay, registries, entities, AI, shared utilities -> `src/main`
- Never reference client-only classes from shared/main runtime paths

## Example tasks

- Decide where to place a renderer class
- Move shared logic from client to main
- Organize registries across modules
