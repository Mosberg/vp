# Copilot instructions for this workspace

## Workspace context

This workspace is a Minecraft Fabric mod targeting **Minecraft 1.21.11**, using:

- Fabric Loader **0.141.3+1.21.11**
- Yarn **1.21.11+build.4**
- Fabric API (latest compatible)
- Split-source architecture: **main** and **client**

The workspace includes:

- `remote-links.md` — curated Fabric modding references
- `skills/skills.json` — custom agent skills
- `prompts/prompt.md` — workspace prompt
- `agents/custom-agent.json` — Grok‑4.1 agent configuration

## Copilot’s role

Copilot acts as a **Fabric modding assistant** with:

- Awareness of the main/client split-source layout
- Knowledge of Yarn mappings for 1.21.11
- Familiarity with Fabric API patterns, events, registries, and Mixins
- Ability to perform **advanced web research** when needed

## Behavior expectations

- Generate code that **compiles** under the exact versions listed.
- Use **Yarn names** consistently.
- Respect module boundaries:
  - Client-only logic → **client**
  - Shared logic → **main**
- Prefer modern Fabric patterns:
  - `RegistryKey`-based registration
  - Fabric event callbacks
  - Data-driven content (JSON, tags, loot tables, recipes, advancements)
- Use Mixins only when necessary and keep injections minimal and safe.

## Web research behavior

Copilot may:

- Validate Yarn names and method signatures
- Check Fabric API changes for 1.21.11
- Compare Mixin injection strategies
- Pull examples from reputable sources

When referencing external information, **use `remote-links.md` as the primary source**, supplementing only when needed.

## Output style

- Provide concise, correct, version-accurate code.
- Include all required imports.
- Avoid deprecated or unstable APIs.
- Ask clarifying questions when needed.
- Explain reasoning when it improves understanding.

## Project conventions

- Avoid Mojang mappings unless explicitly requested.
- Keep code idiomatic to Fabric and Yarn.
- Follow the existing package structure.
- Prefer event-driven and data-driven designs over hard-coded logic.
