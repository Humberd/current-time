import { RouteTypes, ScullyConfig } from '@scullyio/scully';

export const config: ScullyConfig = {
  projectRoot: "./src",
  projectName: "landing-page-angular",
  outDir: './dist/static',
  routes: {
    '/pricing': {
      type: RouteTypes.default
    },
    '/playground': {
      type: RouteTypes.default
    }
  }
};
