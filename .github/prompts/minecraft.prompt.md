# Workspace prompt for Copilot Chat

This workspace is a Minecraft Fabric modding project targeting **Minecraft 1.21.11**.

## Expectations

- Use Yarn names and Fabric API conventions
- Ensure code suggestions compile for listed versions
- Respect split-source layout (client/main)
- Prefer registry keys, event callbacks, data-driven content
- Use Mixins only when necessary

## Web research

- Validate API usage against official docs
- Use curated links in `../remote-links.md` first

## Output style

- Concise, correct, version-accurate code
- Include all required imports
- Avoid deprecated APIs
- Explain reasoning when helpful

## Troubleshooting

- If you encounter build errors, check Yarn mappings and Fabric API versions
- For split-source issues, verify module placement

## Project conventions

- Client-only code stays in the client module
- Shared logic belongs in the main module
- Avoid Mojang mappings unless explicitly requested
- Follow the existing package structure and coding style
