import os
import sys
from jinja2 import Environment, FileSystemLoader


def generate_config(template_file, output_file):
  try:
    j2env = Environment(
      loader=FileSystemLoader(searchpath="."),
      trim_blocks=True
    )
    with open(output_file, 'w') as f:
      template = j2env.get_template(template_file)
      f.write(template.render(env=os.environ))
    return True

  except Exception as e:
    print(e, file=sys.stderr)
    return False


if __name__ == '__main__':
  if len(sys.argv) >= 2:
    template_file = sys.argv[0]
    output_file = sys.argv[1]
    generate_config(template_file,output_file)
