# Copilot instructions for this workspace

These instructions are optimized for VS Code Copilot Chat with GPT-5.3-Codex.

## Project profile

This repository is a Minecraft Fabric mod targeting:

- Minecraft `1.21.11`
- Fabric Loader `0.141.3+1.21.11`
- Yarn `1.21.11+build.4`
- Fabric API compatible with the versions above

Architecture:

- Shared/server logic in `src/main`
- Client-only logic in `src/client`

## Core coding rules

- Generate code that compiles for the exact versions above.
- Use Yarn mappings consistently; avoid Mojang mappings unless explicitly requested.
- Keep code and resources in the correct split-source module.
- Prefer Fabric event callbacks and registry-driven patterns over hard-coded branching.
- Prefer data-driven assets (`data/`, tags, loot tables, recipes, advancements) when practical.
- Use Mixins only when no stable API/event exists; keep injections minimal and resilient.

## Placement rules

- Place rendering, keybinds, screens, particles, HUD, and other client-only code in `src/client`.
- Place gameplay logic, registries, data definitions, entities, and shared utilities in `src/main`.
- Never introduce client classes into main-only codepaths.

## Research and API validation

- Use `.github/remote-links.md` as the first source for Fabric/Yarn/API validation.
- Validate method names/signatures for the target Yarn version before proposing non-trivial API usage.
- Prefer official Fabric docs and mappings references over forum snippets.

## Response expectations

- Keep responses concise and implementation-focused.
- Include required imports in generated Java code.
- Avoid deprecated/unstable APIs when a stable alternative exists.
- Ask for clarification only when a requirement is genuinely ambiguous.
- For non-obvious decisions, include a short rationale.
