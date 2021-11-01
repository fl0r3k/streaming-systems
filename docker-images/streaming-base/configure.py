import os
import sys
from jinja2 import Environment, FileSystemLoader


def env_to_props(env_prefix, exclude=[]):
  props = {}
  for (env_name, val) in os.environ.items():
    if env_name not in exclude and env_name.startswith(env_prefix):
      raw_name = env_name[len(env_prefix):].lower()
      prop_name = '.'.join(raw_name.split('_'))
      props[prop_name] = val
  return props

def generate_config(template_file, output_file):
  try:
    j2env = Environment(
      loader=FileSystemLoader(searchpath="."),
      trim_blocks=True
    )
    j2env.globals['env_to_props'] = env_to_props
    with open(output_file, 'w') as f:
      template = j2env.get_template(template_file)
      f.write(template.render(env=os.environ))
    return True

  except Exception as e:
    print(e, file=sys.stderr)
    return False


if __name__ == '__main__':
  if len(sys.argv) >= 3:
    template_file = sys.argv[1]
    output_file = sys.argv[2]
    generate_config(template_file,output_file)
