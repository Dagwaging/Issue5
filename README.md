# Issue5

Example showing how keeping a static reference to KitClient creates a bad UX on first install

Steps to reproduce:

1. Add your API key to /res/values/secrets.xml
2. Ensure P2P Services is not installed on your test device or emulator
3. Install and run Issue5, observe that it detects no P2P Services package
4. Press 'Go To Google Play' button on dialog, press 'Install' in Google Play
5. Once P2P Services is installed, press back to return to Issue5 (or press home and re-launch it, or use the Recents button)
6. Observe that Issue5 still detects no P2P Services package
7. Kill Issue5 from the Recents screen by swiping it away, re-launch it
8. Observe that Issue5 now detects P2P Services package
