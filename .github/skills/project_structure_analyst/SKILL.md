---
name: project_structure_analyst
description: Understands and navigates split-source modding projects with main and client modules.
disable-model-invocation: false
---

This skill enables the agent to:

- Determine correct module placement for new or existing classes
- Separate client-only logic (rendering, screens, particles) from shared logic
- Suggest refactors to maintain clean module boundaries
- Ensure generated code respects the project’s architecture

Examples:

- Decide where to place a renderer class
- Move shared logic from client to main
- Organize registries across modules
